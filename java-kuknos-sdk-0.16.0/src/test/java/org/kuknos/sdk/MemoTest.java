package org.kuknos.sdk;

import com.google.common.io.BaseEncoding;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.kuknos.sdk.MemoHash;
import org.kuknos.sdk.MemoNone;
import org.kuknos.sdk.MemoReturnHash;
import org.kuknos.sdk.MemoText;
import org.kuknos.sdk.MemoTooLongException;
import org.kuknos.sdk.Util;
import org.kuknos.sdk.xdr.Memo;
import org.kuknos.sdk.xdr.MemoType;
import org.kuknos.sdk.MemoId;
import org.kuknos.sdk.responses.TransactionDeserializer;
import org.kuknos.sdk.responses.TransactionResponse;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MemoTest {
    @Test
    public void testMemoNone() {
        MemoNone memo = org.kuknos.sdk.Memo.none();
        assertEquals(MemoType.MEMO_NONE, memo.toXdr().getDiscriminant());
        assertEquals("", memo.toString());
    }

    @Test
    public void testMemoTextSuccess() {
        MemoText memo = org.kuknos.sdk.Memo.text("test");
        assertEquals(MemoType.MEMO_TEXT, memo.toXdr().getDiscriminant());
        assertEquals("test", memo.getText());
        assertEquals("test", memo.toString());
    }

    @Test
    public void testMemoTextUtf8() {
        MemoText memo = org.kuknos.sdk.Memo.text("三");
        assertEquals(MemoType.MEMO_TEXT, memo.toXdr().getDiscriminant());
        assertEquals("三", memo.getText());
        assertEquals("三", memo.toString());
    }

    @Test
    public void testMemoTextTooLong() {
        try {
            org.kuknos.sdk.Memo.text("12345678901234567890123456789");
            fail();
        } catch (RuntimeException exception) {
            assertTrue(exception.getMessage().contains("text must be <= 28 bytes."));
        }
    }

    @Test
    public void testMemoTextTooLongUtf8() {
        try {
            org.kuknos.sdk.Memo.text("价值交易的开源协议!!");
            fail();
        } catch (RuntimeException exception) {
            assertTrue(exception.getMessage().contains("text must be <= 28 bytes."));
        }
    }

    @Test
    public void testMemoId() {
        MemoId memo = org.kuknos.sdk.Memo.id(9223372036854775807L);
        assertEquals(9223372036854775807L, memo.getId());
        assertEquals(MemoType.MEMO_ID, memo.toXdr().getDiscriminant());
        assertEquals(new Long(9223372036854775807L), memo.toXdr().getId().getUint64());
        assertEquals("9223372036854775807", memo.toString());
    }

    @Test
    public void testParseMemoId() {
        String longId = "10048071741004807174";
        JsonElement element = new JsonParser().parse(String.format("{ \"memo_type\": \"id\", \"memo\": \"%s\" }", longId));
        TransactionResponse transactionResponse = new TransactionDeserializer().deserialize(element, null, null);
        MemoId memoId = (MemoId)transactionResponse.getMemo();
        assertEquals(longId, Long.toUnsignedString(memoId.getId()));
    }

    @Test
    public void testMemoHashSuccess() {
        MemoHash memo = org.kuknos.sdk.Memo.hash("4142434445464748494a4b4c");
        assertEquals(MemoType.MEMO_HASH, memo.toXdr().getDiscriminant());
        String test = "ABCDEFGHIJKL";
        assertEquals(test, Util.paddedByteArrayToString(memo.getBytes()));
        assertEquals("4142434445464748494a4b4c", memo.getTrimmedHexValue());
        assertEquals("ABCDEFGHIJKL", memo.toString());
    }

    @Test
    public void testMemoHashSuccessUppercase() {
        MemoHash memo = org.kuknos.sdk.Memo.hash("4142434445464748494a4b4c".toUpperCase());
        assertEquals(MemoType.MEMO_HASH, memo.toXdr().getDiscriminant());
        String test = "ABCDEFGHIJKL";
        assertEquals(test, Util.paddedByteArrayToString(memo.getBytes()));
        assertEquals("4142434445464748494a4b4c", memo.getTrimmedHexValue());
    }

    @Test
    public void testMemoHashBytesSuccess() {
        byte[] bytes = new byte[10];
        Arrays.fill(bytes, (byte) 'A');
        MemoHash memo = org.kuknos.sdk.Memo.hash(bytes);
        assertEquals(MemoType.MEMO_HASH, memo.toXdr().getDiscriminant());
        assertEquals("AAAAAAAAAA", Util.paddedByteArrayToString(memo.getBytes()));
        assertEquals("4141414141414141414100000000000000000000000000000000000000000000", memo.getHexValue());
        assertEquals("41414141414141414141", memo.getTrimmedHexValue());
    }

    @Test
    public void testMemoHashTooLong() {
        byte[] longer = new byte[33];
        Arrays.fill(longer, (byte) 0);
        try {
            org.kuknos.sdk.Memo.hash(longer);
            fail();
        } catch (MemoTooLongException exception) {
            assertTrue(exception.getMessage().contains("MEMO_HASH can contain 32 bytes at max."));
        }
    }

    @Test
    public void testMemoHashInvalidHex() {
        try {
            org.kuknos.sdk.Memo.hash("test");
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testMemoReturnHashSuccess() {
        MemoReturnHash memo = org.kuknos.sdk.Memo.returnHash("4142434445464748494a4b4c");
        Memo memoXdr = memo.toXdr();
        assertEquals(MemoType.MEMO_RETURN, memoXdr.getDiscriminant());
        assertNull(memoXdr.getHash());
        assertEquals("4142434445464748494a4b4c0000000000000000000000000000000000000000", BaseEncoding.base16().lowerCase().encode(memoXdr.getRetHash().getHash()));
        assertEquals("4142434445464748494a4b4c", memo.getTrimmedHexValue());
    }
}

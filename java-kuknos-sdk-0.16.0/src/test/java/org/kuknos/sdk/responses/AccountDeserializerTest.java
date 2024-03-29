package org.kuknos.sdk.responses;

import junit.framework.TestCase;

import org.junit.Test;
import org.kuknos.sdk.responses.AccountResponse;
import org.kuknos.sdk.responses.GsonSingleton;

import java.util.Arrays;

public class AccountDeserializerTest extends TestCase {
  @Test
  public void testDeserializeBalanceAuth() {
    AccountResponse account = GsonSingleton.getInstance().fromJson(jsonAuthorizedToMaintainLiabilities, AccountResponse.class);

    assertEquals(account.getBalances()[0].getAssetType(), "credit_alphanum4");
    assertEquals(account.getBalances()[0].getAssetCode(), "ABC");
    assertEquals(account.getBalances()[0].getAssetIssuer(), "GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU");
    assertEquals(account.getBalances()[0].getBalance(), "1001.0000000");
    assertEquals(account.getBalances()[0].getLimit(), "12000.4775807");
    assertEquals(account.getBalances()[0].getBuyingLiabilities(), "100.1234567");
    assertEquals(account.getBalances()[0].getSellingLiabilities(), "100.7654321");
    assertEquals(account.getBalances()[0].getAuthorized(), Boolean.FALSE);
    assertEquals(account.getBalances()[0].getAuthorizedToMaintainLiabilities(), Boolean.TRUE);

    assertEquals(account.getBalances()[1].getAssetType(), "native");
    assertEquals(account.getBalances()[1].getBalance(), "20.0000300");
    assertEquals(account.getBalances()[1].getBuyingLiabilities(), "5.1234567");
    assertEquals(account.getBalances()[1].getSellingLiabilities(), "1.7654321");
    assertEquals(account.getBalances()[1].getLimit(), null);
  }

  @Test
  public void testDeserialize() {
    AccountResponse account = GsonSingleton.getInstance().fromJson(json, AccountResponse.class);
      assertEquals(account.getAccountId(), "GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7");
    assertEquals(account.getSequenceNumber(), new Long(2319149195853854L));
    assertEquals(account.getSubentryCount(), new Integer(0));
    assertEquals(account.getInflationDestination(), "GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC");
    assertEquals(account.getHomeDomain(), "stellar.org");

    assertEquals(account.getThresholds().getLowThreshold(), 10);
    assertEquals(account.getThresholds().getMedThreshold(), 20);
    assertEquals(account.getThresholds().getHighThreshold(), 30);

    assertEquals(account.getFlags().getAuthRequired(), false);
    assertEquals(account.getFlags().getAuthRevocable(), true);
    assertEquals(account.getFlags().getAuthImmutable(), true);

    assertEquals(account.getBalances()[0].getAssetType(), "credit_alphanum4");
    assertEquals(account.getBalances()[0].getAssetCode(), "ABC");
    assertEquals(account.getBalances()[0].getAssetIssuer(), "GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU");
    assertEquals(account.getBalances()[0].getBalance(), "1001.0000000");
    assertEquals(account.getBalances()[0].getLimit(), "12000.4775807");
    assertEquals(account.getBalances()[0].getBuyingLiabilities(), "100.1234567");
    assertEquals(account.getBalances()[0].getSellingLiabilities(), "100.7654321");

    assertEquals(account.getBalances()[1].getAssetType(), "native");
    assertEquals(account.getBalances()[1].getBalance(), "20.0000300");
    assertEquals(account.getBalances()[1].getBuyingLiabilities(), "5.1234567");
    assertEquals(account.getBalances()[1].getSellingLiabilities(), "1.7654321");
    assertEquals(account.getBalances()[1].getLimit(), null);

    assertEquals(account.getSigners()[0].getAccountId(), "GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7");
    assertEquals(account.getSigners()[0].getWeight(), 0);
    assertEquals(account.getSigners()[0].getType(), "ed25519_public_key");
    assertEquals(account.getSigners()[1].getKey(), "GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2");
    assertEquals(account.getSigners()[1].getWeight(), 1);
    assertEquals(account.getSigners()[1].getType(), "ed25519_public_key");

    assertEquals(account.getData().size(), 2);
    assertEquals(account.getData().get("entry1"), "dGVzdA==");
    assertTrue(Arrays.equals(account.getData().getDecoded("entry1"), "test".getBytes()));
    assertEquals(account.getData().get("entry2"), "dGVzdDI=");
    assertTrue(Arrays.equals(account.getData().getDecoded("entry2"), "test2".getBytes()));

    assertEquals(account.getLinks().getEffects().getHref(), "/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/effects{?cursor,limit,order}");
    assertEquals(account.getLinks().getOffers().getHref(), "/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/offers{?cursor,limit,order}");
    assertEquals(account.getLinks().getOperations().getHref(), "/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/operations{?cursor,limit,order}");
    assertEquals(account.getLinks().getSelf().getHref(), "/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7");
    assertEquals(account.getLinks().getTransactions().getHref(), "/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/transactions{?cursor,limit,order}");
  }

  @Test
  public void testDeserializeV9() {
    AccountResponse account = GsonSingleton.getInstance().fromJson(jsonV9, AccountResponse.class);

    assertEquals(account.getBalances()[0].getAssetType(), "credit_alphanum4");
    assertEquals(account.getBalances()[0].getAssetCode(), "ABC");
    assertEquals(account.getBalances()[0].getAssetIssuer(), "GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU");
    assertEquals(account.getBalances()[0].getBalance(), "1001.0000000");
    assertEquals(account.getBalances()[0].getLimit(), "12000.4775807");
    assertEquals(account.getBalances()[0].getBuyingLiabilities(), null);
    assertEquals(account.getBalances()[0].getSellingLiabilities(), null);

    assertEquals(account.getBalances()[1].getAssetType(), "native");
    assertEquals(account.getBalances()[1].getBalance(), "20.0000300");
    assertEquals(account.getBalances()[1].getBuyingLiabilities(), null);
    assertEquals(account.getBalances()[1].getSellingLiabilities(), null);
    assertEquals(account.getBalances()[1].getLimit(), null);
  }

  String jsonAuthorizedToMaintainLiabilities = "{\n" +
      "  \"_links\": {\n" +
      "    \"effects\": {\n" +
      "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/effects{?cursor,limit,order}\",\n" +
      "      \"templated\": true\n" +
      "    },\n" +
      "    \"offers\": {\n" +
      "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/offers{?cursor,limit,order}\",\n" +
      "      \"templated\": true\n" +
      "    },\n" +
      "    \"operations\": {\n" +
      "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/operations{?cursor,limit,order}\",\n" +
      "      \"templated\": true\n" +
      "    },\n" +
      "    \"self\": {\n" +
      "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\"\n" +
      "    },\n" +
      "    \"transactions\": {\n" +
      "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/transactions{?cursor,limit,order}\",\n" +
      "      \"templated\": true\n" +
      "    }\n" +
      "  },"+
      "  \"id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
      "  \"paging_token\": \"1\",\n" +
      "  \"account_id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
      "  \"sequence\": 2319149195853854,\n" +
      "  \"subentry_count\": 0,\n" +
      "  \"inflation_destination\": \"GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC\",\n" +
      "  \"home_domain\": \"stellar.org\",\n" +
      "  \"thresholds\": {\n" +
      "    \"low_threshold\": 10,\n" +
      "    \"med_threshold\": 20,\n" +
      "    \"high_threshold\": 30\n" +
      "  },\n" +
      "  \"flags\": {\n" +
      "    \"auth_required\": false,\n" +
      "    \"auth_revocable\": true,\n" +
      "    \"auth_immutable\": true\n" +
      "  },\n" +
      "  \"balances\": [\n" +
      "    {\n" +
      "      \"balance\": \"1001.0000000\",\n" +
      "      \"buying_liabilities\": \"100.1234567\",\n" +
      "      \"selling_liabilities\": \"100.7654321\",\n" +
      "      \"limit\": \"12000.4775807\",\n" +
      "      \"asset_type\": \"credit_alphanum4\",\n" +
      "      \"asset_code\": \"ABC\",\n" +
      "      \"asset_issuer\": \"GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU\",\n" +
      "      \"is_authorized\": false,\n" +
      "      \"is_authorized_to_maintain_liabilities\": true\n" +
      "    },"+
      "    {\n" +
      "      \"asset_type\": \"native\",\n" +
      "      \"balance\": \"20.0000300\",\n" +
      "      \"buying_liabilities\": \"5.1234567\",\n" +
      "      \"selling_liabilities\": \"1.7654321\"\n" +
      "    }\n" +
      "  ],\n" +
      "  \"signers\": [\n" +
      "    {\n" +
      "      \"public_key\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
      "      \"key\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
      "      \"weight\": 0,\n" +
      "      \"type\": \"ed25519_public_key\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"public_key\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
      "      \"key\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
      "      \"weight\": 1,\n" +
      "      \"type\": \"ed25519_public_key\"\n" +
      "    }\n" +
      "  ],\n" +
      "  \"data\": {\n" +
      "    \"entry1\": \"dGVzdA==\",\n" +
      "    \"entry2\": \"dGVzdDI=\"\n" +
      "  }" +
      "}";

  String json = "{\n" +
          "  \"_links\": {\n" +
          "    \"effects\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/effects{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"offers\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/offers{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"operations\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/operations{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"self\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\"\n" +
          "    },\n" +
          "    \"transactions\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/transactions{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    }\n" +
          "  },"+
          "  \"id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "  \"paging_token\": \"1\",\n" +
          "  \"account_id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "  \"sequence\": 2319149195853854,\n" +
          "  \"subentry_count\": 0,\n" +
          "  \"inflation_destination\": \"GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC\",\n" +
          "  \"home_domain\": \"stellar.org\",\n" +
          "  \"thresholds\": {\n" +
          "    \"low_threshold\": 10,\n" +
          "    \"med_threshold\": 20,\n" +
          "    \"high_threshold\": 30\n" +
          "  },\n" +
          "  \"flags\": {\n" +
          "    \"auth_required\": false,\n" +
          "    \"auth_revocable\": true,\n" +
          "    \"auth_immutable\": true\n" +
          "  },\n" +
          "  \"balances\": [\n" +
          "    {\n" +
          "      \"balance\": \"1001.0000000\",\n" +
          "      \"buying_liabilities\": \"100.1234567\",\n" +
          "      \"selling_liabilities\": \"100.7654321\",\n" +
          "      \"limit\": \"12000.4775807\",\n" +
          "      \"asset_type\": \"credit_alphanum4\",\n" +
          "      \"asset_code\": \"ABC\",\n" +
          "      \"asset_issuer\": \"GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU\"\n" +
          "    },"+
          "    {\n" +
          "      \"asset_type\": \"native\",\n" +
          "      \"balance\": \"20.0000300\",\n" +
          "      \"buying_liabilities\": \"5.1234567\",\n" +
          "      \"selling_liabilities\": \"1.7654321\"\n" +
          "    }\n" +
          "  ],\n" +
          "  \"signers\": [\n" +
          "    {\n" +
          "      \"public_key\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "      \"key\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "      \"weight\": 0,\n" +
          "      \"type\": \"ed25519_public_key\"\n" +
          "    },\n" +
          "    {\n" +
          "      \"public_key\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
          "      \"key\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
          "      \"weight\": 1,\n" +
          "      \"type\": \"ed25519_public_key\"\n" +
          "    }\n" +
          "  ],\n" +
          "  \"data\": {\n" +
          "    \"entry1\": \"dGVzdA==\",\n" +
          "    \"entry2\": \"dGVzdDI=\"\n" +
          "  }" +
          "}";

  String jsonV9 = "{\n" +
          "  \"_links\": {\n" +
          "    \"effects\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/effects{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"offers\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/offers{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"operations\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/operations{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    },\n" +
          "    \"self\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\"\n" +
          "    },\n" +
          "    \"transactions\": {\n" +
          "      \"href\": \"/accounts/GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7/transactions{?cursor,limit,order}\",\n" +
          "      \"templated\": true\n" +
          "    }\n" +
          "  },"+
          "  \"id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "  \"paging_token\": \"1\",\n" +
          "  \"account_id\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "  \"sequence\": 2319149195853854,\n" +
          "  \"subentry_count\": 0,\n" +
          "  \"inflation_destination\": \"GAGRSA6QNQJN2OQYCBNQGMFLO4QLZFNEHIFXOMTQVSUTWVTWT66TOFSC\",\n" +
          "  \"home_domain\": \"stellar.org\",\n" +
          "  \"thresholds\": {\n" +
          "    \"low_threshold\": 10,\n" +
          "    \"med_threshold\": 20,\n" +
          "    \"high_threshold\": 30\n" +
          "  },\n" +
          "  \"flags\": {\n" +
          "    \"auth_required\": false,\n" +
          "    \"auth_revocable\": true\n" +
          "  },\n" +
          "  \"balances\": [\n" +
          "    {\n" +
          "      \"balance\": \"1001.0000000\",\n" +
          "      \"limit\": \"12000.4775807\",\n" +
          "      \"asset_type\": \"credit_alphanum4\",\n" +
          "      \"asset_code\": \"ABC\",\n" +
          "      \"asset_issuer\": \"GCRA6COW27CY5MTKIA7POQ2326C5ABYCXODBN4TFF5VL4FMBRHOT3YHU\"\n" +
          "    },"+
          "    {\n" +
          "      \"asset_type\": \"native\",\n" +
          "      \"balance\": \"20.0000300\"\n" +
          "    }\n" +
          "  ],\n" +
          "  \"signers\": [\n" +
          "    {\n" +
          "      \"public_key\": \"GAAZI4TCR3TY5OJHCTJC2A4QSY6CJWJH5IAJTGKIN2ER7LBNVKOCCWN7\",\n" +
          "      \"weight\": 0\n" +
          "    },\n" +
          "    {\n" +
          "      \"public_key\": \"GCR2KBCIU6KQXSQY5F5GZYC4WLNHCHCKW4NEGXNEZRYWLTNZIRJJY7D2\",\n" +
          "      \"weight\": 1\n" +
          "    }\n" +
          "  ]\n" +
          "}";
}

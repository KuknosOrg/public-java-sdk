package org.kuknos.sdk;

import com.google.common.base.Objects;

import org.kuknos.sdk.xdr.OperationType;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html#inflation" target="_blank">Inflation</a> operation.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class InflationOperation extends Operation {
    @Override
    org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
        org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.INFLATION);
        return body;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getSourceAccount());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof InflationOperation)) {
            return false;
        }

        InflationOperation other = (InflationOperation) object;
        return Objects.equal(this.getSourceAccount(), other.getSourceAccount());
    }
}

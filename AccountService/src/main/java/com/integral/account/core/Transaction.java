package com.integral.account.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Transaction {

    public static enum Type {
        DEPOSIT, WITHDRAWAL;
    }

    public abstract String getId();

    public abstract String getAccountId();

    public abstract String getToAddress();

    public abstract String getFromAddress();

    public abstract Type getType();

    public abstract double getAmount();

    public abstract String getSymbol();

    public abstract int getDecimal();

    public abstract String getTimestamp();

    public abstract String getTxnHash();

    public static Builder builder() {
        return new AutoValue_Transaction.Builder()
        .setSymbol("ETH").setDecimal(18);
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setId(String value);

        public abstract Builder setAccountId(String value);

        public abstract Builder setToAddress(String value);

        public abstract Builder setFromAddress(String value);

        public abstract Builder setType(Type value);

        public abstract Builder setAmount(double value);

        public abstract Builder setSymbol(String value);

        public abstract Builder setDecimal(int value);

        public abstract Builder setTimestamp(String value);

        public abstract Builder setTxnHash(String value);

        public abstract Transaction build();
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

}



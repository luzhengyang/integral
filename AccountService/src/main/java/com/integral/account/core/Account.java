package com.integral.account.core;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Account {

    public abstract String getAccountId();

    public abstract String getAccountAddress();

    public abstract double getBalance();

    public abstract String getSymbol();

    public abstract Set<Transaction> getTransactions();

    public static Builder builder() {
        return new AutoValue_Account.Builder()
        .setBalance(0.0)
        .setSymbol("ETH")
        .setTransactions(new HashSet<>());
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setAccountId(String value);

        public abstract Builder setAccountAddress(String value);

        public abstract Builder setBalance(double value);

        public abstract Builder setSymbol(String value);

        public abstract Builder setTransactions(Set<Transaction> value);

        public abstract Account build();
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
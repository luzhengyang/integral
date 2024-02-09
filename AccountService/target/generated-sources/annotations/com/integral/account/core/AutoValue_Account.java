package com.integral.account.core;

import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Account extends Account {

  private final String accountId;

  private final String accountAddress;

  private final double balance;

  private final String symbol;

  private final Set<Transaction> transactions;

  private AutoValue_Account(
      String accountId,
      String accountAddress,
      double balance,
      String symbol,
      Set<Transaction> transactions) {
    this.accountId = accountId;
    this.accountAddress = accountAddress;
    this.balance = balance;
    this.symbol = symbol;
    this.transactions = transactions;
  }

  @Override
  public String getAccountId() {
    return accountId;
  }

  @Override
  public String getAccountAddress() {
    return accountAddress;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public Set<Transaction> getTransactions() {
    return transactions;
  }

  @Override
  public String toString() {
    return "Account{"
        + "accountId=" + accountId + ", "
        + "accountAddress=" + accountAddress + ", "
        + "balance=" + balance + ", "
        + "symbol=" + symbol + ", "
        + "transactions=" + transactions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Account) {
      Account that = (Account) o;
      return this.accountId.equals(that.getAccountId())
          && this.accountAddress.equals(that.getAccountAddress())
          && Double.doubleToLongBits(this.balance) == Double.doubleToLongBits(that.getBalance())
          && this.symbol.equals(that.getSymbol())
          && this.transactions.equals(that.getTransactions());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= accountId.hashCode();
    h$ *= 1000003;
    h$ ^= accountAddress.hashCode();
    h$ *= 1000003;
    h$ ^= (int) ((Double.doubleToLongBits(balance) >>> 32) ^ Double.doubleToLongBits(balance));
    h$ *= 1000003;
    h$ ^= symbol.hashCode();
    h$ *= 1000003;
    h$ ^= transactions.hashCode();
    return h$;
  }

  static final class Builder extends Account.Builder {
    private String accountId;
    private String accountAddress;
    private double balance;
    private String symbol;
    private Set<Transaction> transactions;
    private byte set$0;
    Builder() {
    }
    @Override
    public Account.Builder setAccountId(String accountId) {
      if (accountId == null) {
        throw new NullPointerException("Null accountId");
      }
      this.accountId = accountId;
      return this;
    }
    @Override
    public Account.Builder setAccountAddress(String accountAddress) {
      if (accountAddress == null) {
        throw new NullPointerException("Null accountAddress");
      }
      this.accountAddress = accountAddress;
      return this;
    }
    @Override
    public Account.Builder setBalance(double balance) {
      this.balance = balance;
      set$0 |= (byte) 1;
      return this;
    }
    @Override
    public Account.Builder setSymbol(String symbol) {
      if (symbol == null) {
        throw new NullPointerException("Null symbol");
      }
      this.symbol = symbol;
      return this;
    }
    @Override
    public Account.Builder setTransactions(Set<Transaction> transactions) {
      if (transactions == null) {
        throw new NullPointerException("Null transactions");
      }
      this.transactions = transactions;
      return this;
    }
    @Override
    public Account build() {
      if (set$0 != 1
          || this.accountId == null
          || this.accountAddress == null
          || this.symbol == null
          || this.transactions == null) {
        StringBuilder missing = new StringBuilder();
        if (this.accountId == null) {
          missing.append(" accountId");
        }
        if (this.accountAddress == null) {
          missing.append(" accountAddress");
        }
        if ((set$0 & 1) == 0) {
          missing.append(" balance");
        }
        if (this.symbol == null) {
          missing.append(" symbol");
        }
        if (this.transactions == null) {
          missing.append(" transactions");
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Account(
          this.accountId,
          this.accountAddress,
          this.balance,
          this.symbol,
          this.transactions);
    }
  }

}

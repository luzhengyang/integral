package com.integral.account.core;

import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Transaction extends Transaction {

  private final String id;

  private final String accountId;

  private final String toAddress;

  private final String fromAddress;

  private final Transaction.Type type;

  private final double amount;

  private final String symbol;

  private final int decimal;

  private final String timestamp;

  private final String txnHash;

  private AutoValue_Transaction(
      String id,
      String accountId,
      String toAddress,
      String fromAddress,
      Transaction.Type type,
      double amount,
      String symbol,
      int decimal,
      String timestamp,
      String txnHash) {
    this.id = id;
    this.accountId = accountId;
    this.toAddress = toAddress;
    this.fromAddress = fromAddress;
    this.type = type;
    this.amount = amount;
    this.symbol = symbol;
    this.decimal = decimal;
    this.timestamp = timestamp;
    this.txnHash = txnHash;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getAccountId() {
    return accountId;
  }

  @Override
  public String getToAddress() {
    return toAddress;
  }

  @Override
  public String getFromAddress() {
    return fromAddress;
  }

  @Override
  public Transaction.Type getType() {
    return type;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public int getDecimal() {
    return decimal;
  }

  @Override
  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public String getTxnHash() {
    return txnHash;
  }

  @Override
  public String toString() {
    return "Transaction{"
        + "id=" + id + ", "
        + "accountId=" + accountId + ", "
        + "toAddress=" + toAddress + ", "
        + "fromAddress=" + fromAddress + ", "
        + "type=" + type + ", "
        + "amount=" + amount + ", "
        + "symbol=" + symbol + ", "
        + "decimal=" + decimal + ", "
        + "timestamp=" + timestamp + ", "
        + "txnHash=" + txnHash
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Transaction) {
      Transaction that = (Transaction) o;
      return this.id.equals(that.getId())
          && this.accountId.equals(that.getAccountId())
          && this.toAddress.equals(that.getToAddress())
          && this.fromAddress.equals(that.getFromAddress())
          && this.type.equals(that.getType())
          && Double.doubleToLongBits(this.amount) == Double.doubleToLongBits(that.getAmount())
          && this.symbol.equals(that.getSymbol())
          && this.decimal == that.getDecimal()
          && this.timestamp.equals(that.getTimestamp())
          && this.txnHash.equals(that.getTxnHash());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= id.hashCode();
    h$ *= 1000003;
    h$ ^= accountId.hashCode();
    h$ *= 1000003;
    h$ ^= toAddress.hashCode();
    h$ *= 1000003;
    h$ ^= fromAddress.hashCode();
    h$ *= 1000003;
    h$ ^= type.hashCode();
    h$ *= 1000003;
    h$ ^= (int) ((Double.doubleToLongBits(amount) >>> 32) ^ Double.doubleToLongBits(amount));
    h$ *= 1000003;
    h$ ^= symbol.hashCode();
    h$ *= 1000003;
    h$ ^= decimal;
    h$ *= 1000003;
    h$ ^= timestamp.hashCode();
    h$ *= 1000003;
    h$ ^= txnHash.hashCode();
    return h$;
  }

  static final class Builder extends Transaction.Builder {
    private String id;
    private String accountId;
    private String toAddress;
    private String fromAddress;
    private Transaction.Type type;
    private double amount;
    private String symbol;
    private int decimal;
    private String timestamp;
    private String txnHash;
    private byte set$0;
    Builder() {
    }
    @Override
    public Transaction.Builder setId(String id) {
      if (id == null) {
        throw new NullPointerException("Null id");
      }
      this.id = id;
      return this;
    }
    @Override
    public Transaction.Builder setAccountId(String accountId) {
      if (accountId == null) {
        throw new NullPointerException("Null accountId");
      }
      this.accountId = accountId;
      return this;
    }
    @Override
    public Transaction.Builder setToAddress(String toAddress) {
      if (toAddress == null) {
        throw new NullPointerException("Null toAddress");
      }
      this.toAddress = toAddress;
      return this;
    }
    @Override
    public Transaction.Builder setFromAddress(String fromAddress) {
      if (fromAddress == null) {
        throw new NullPointerException("Null fromAddress");
      }
      this.fromAddress = fromAddress;
      return this;
    }
    @Override
    public Transaction.Builder setType(Transaction.Type type) {
      if (type == null) {
        throw new NullPointerException("Null type");
      }
      this.type = type;
      return this;
    }
    @Override
    public Transaction.Builder setAmount(double amount) {
      this.amount = amount;
      set$0 |= (byte) 1;
      return this;
    }
    @Override
    public Transaction.Builder setSymbol(String symbol) {
      if (symbol == null) {
        throw new NullPointerException("Null symbol");
      }
      this.symbol = symbol;
      return this;
    }
    @Override
    public Transaction.Builder setDecimal(int decimal) {
      this.decimal = decimal;
      set$0 |= (byte) 2;
      return this;
    }
    @Override
    public Transaction.Builder setTimestamp(String timestamp) {
      if (timestamp == null) {
        throw new NullPointerException("Null timestamp");
      }
      this.timestamp = timestamp;
      return this;
    }
    @Override
    public Transaction.Builder setTxnHash(String txnHash) {
      if (txnHash == null) {
        throw new NullPointerException("Null txnHash");
      }
      this.txnHash = txnHash;
      return this;
    }
    @Override
    public Transaction build() {
      if (set$0 != 3
          || this.id == null
          || this.accountId == null
          || this.toAddress == null
          || this.fromAddress == null
          || this.type == null
          || this.symbol == null
          || this.timestamp == null
          || this.txnHash == null) {
        StringBuilder missing = new StringBuilder();
        if (this.id == null) {
          missing.append(" id");
        }
        if (this.accountId == null) {
          missing.append(" accountId");
        }
        if (this.toAddress == null) {
          missing.append(" toAddress");
        }
        if (this.fromAddress == null) {
          missing.append(" fromAddress");
        }
        if (this.type == null) {
          missing.append(" type");
        }
        if ((set$0 & 1) == 0) {
          missing.append(" amount");
        }
        if (this.symbol == null) {
          missing.append(" symbol");
        }
        if ((set$0 & 2) == 0) {
          missing.append(" decimal");
        }
        if (this.timestamp == null) {
          missing.append(" timestamp");
        }
        if (this.txnHash == null) {
          missing.append(" txnHash");
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Transaction(
          this.id,
          this.accountId,
          this.toAddress,
          this.fromAddress,
          this.type,
          this.amount,
          this.symbol,
          this.decimal,
          this.timestamp,
          this.txnHash);
    }
  }

}

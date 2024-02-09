package com.integral.account.resources;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;
import com.integral.account.core.Transaction;
import com.integral.account.db.TransactionDAO;

@Path("/accounts/{accountId}/trasactions")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    private TransactionDAO transactionDAO;

    @Inject
    public TransactionResource(TransactionDAO transactionDAO) {
        this.transactionDAO = Objects.requireNonNull(transactionDAO, "transactionDAO cannot be null");
    }

    @GET
    public List<Transaction> getTransaction(@PathParam("accountId") String accountId) {

        return transactionDAO.getTransactionsOfAccount(accountId);
    }

    @POST
    public Transaction createTransaction(@PathParam("accountId") String accountId) {
        Transaction transaction = Transaction.builder()
        .setId(getUuid())
        .setAccountId(accountId)
        .setAmount(0.0)
        .setSymbol("ETH")
        .setDecimal(18)
        .setFromAddress("0xc5102fe9359fd9a28f877a67e36b0f050d81a3cc")
        .setToAddress("0x9aa99c23f67c81701c772b106b4f83f6e858dd2e")
        .setType(Transaction.Type.DEPOSIT)
        .setTimestamp(getTimestamp())
        .setTxnHash("0xaa45b4858ba44230a5fce5a29570a5dec2bf1f0ba95bacdec4fe8f2c4fa99338")
        .build();
        transactionDAO.save(transaction);
        return transaction;
    }

    @VisibleForTesting
    String getUuid() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }

    @VisibleForTesting 
    String getTimestamp() {
        Instant now = Instant.now();
        return DateTimeFormatter.ISO_INSTANT.format(now);
    }
}

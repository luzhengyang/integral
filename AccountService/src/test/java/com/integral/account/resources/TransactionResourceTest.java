package com.integral.account.resources;

import com.integral.account.core.Transaction;
import com.integral.account.db.TransactionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionResourceTest {

    private TransactionResource transactionResource;
    private TransactionDAO transactionDAO;

    @BeforeEach
    public void setUp() {
        transactionDAO = mock(TransactionDAO.class);
        transactionResource = new TransactionResource(transactionDAO);
    }

    @Test
    public void testGetTransaction() {

        Transaction transaction1 = Transaction.builder()
        .setId("tx1")
        .setAccountId("foo1")
        .setType(Transaction.Type.DEPOSIT)
        .setAmount(100.00)
        .setFromAddress("from")
        .setToAddress("to")
        .setTimestamp("2020-01-01T00:00:00Z")
        .setTxnHash("xxx1")
        .build();
        
        Transaction transaction2 = Transaction.builder()
        .setId("tx2")
        .setAccountId("foo1")
        .setType(Transaction.Type.DEPOSIT)
        .setAmount(50.00)
        .setFromAddress("from")
        .setToAddress("to")
        .setTimestamp("2020-01-02T00:00:00Z")
        .setTxnHash("xxx2")
        .build();

        List<Transaction> transactions = List.of(transaction1, transaction2);
        when(transactionDAO.getTransactionsOfAccount("foo1")).thenReturn(transactions);

        List<Transaction> result = transactionResource.getTransaction("foo1");
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}

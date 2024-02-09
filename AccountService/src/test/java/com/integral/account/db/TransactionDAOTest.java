package com.integral.account.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.integral.account.core.Account;
import com.integral.account.core.Transaction;

public class TransactionDAOTest {

    private TransactionDAO transactionDAO;
    private AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        accountDAO = new AccountDAO();
        transactionDAO = new TransactionDAO(accountDAO);
    }

    @Test
    public void testGetTransactionsOfAccount() {
        Account account = Account.builder().setAccountId("foo1").setAccountAddress("bar1").build();
        accountDAO.save(account);
        
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
        
        transactionDAO.save(transaction1);
        transactionDAO.save(transaction2);
        
        List<Transaction> transactions = transactionDAO.getTransactionsOfAccount("foo1");
        assertEquals(2, transactions.size());
        assertEquals(transaction1, transactions.get(0));
        assertEquals(transaction2, transactions.get(1));
    }

    @Test
    public void testSave() {
        Account account = Account.builder().setAccountId("foo1").setAccountAddress("bar1").build();
        accountDAO.save(account);
        
        Transaction transaction = Transaction.builder()
        .setId("tx3")
        .setAccountId("foo1")
        .setType(Transaction.Type.DEPOSIT)
        .setAmount(75.00)
        .setFromAddress("from")
        .setToAddress("to")
        .setTimestamp("2020-01-01T00:00:00Z")
        .setTxnHash("xxx3")
        .build();
        
        transactionDAO.save(transaction);
        
        List<Transaction> transactions = transactionDAO.getTransactionsOfAccount("foo1");
        assertEquals(1, transactions.size());
        assertEquals(transaction, transactions.get(0));
    }
}

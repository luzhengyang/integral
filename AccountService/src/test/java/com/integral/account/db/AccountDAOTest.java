package com.integral.account.db;

import com.integral.account.core.Account;
import com.integral.account.core.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class AccountDAOTest {

    private AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        accountDAO = new AccountDAO();
    }

    @Test
    public void testGetAll() {
        Set<Account> accounts = accountDAO.getAll();
        assertNotNull(accounts);
    }

    @Test
    public void testGetExistingAccount() {
        Account account = Account.builder().setAccountId("foo1").setAccountAddress("bar1").build();
        accountDAO.save(account);
        Optional<Account> retrievedAccount = accountDAO.get("foo1");
        assertTrue(retrievedAccount.isPresent());
        assertEquals(account, retrievedAccount.get());
    }

    @Test
    public void testGetNonExistingAccount() {
        Optional<Account> retrievedAccount = accountDAO.get("abc");
        assertTrue(retrievedAccount.isEmpty());
    }

    @Test
    public void testSave() {
        Account account = Account.builder().setAccountId("foo1").setAccountAddress("bar1").build();
        accountDAO.save(account);
        Set<Account> accounts = accountDAO.getAll();
        assertTrue(accounts.contains(account));
    }

    @Test
    public void testAddTransactionToExistingAccount() {
        Account account = Account.builder().setAccountId("foo2").setAccountAddress("bar2").build();
        Transaction transaction = Transaction.builder()
        .setId("tx1")
        .setType(Transaction.Type.DEPOSIT)
        .setAccountId("foo2")
        .setAmount(0.0)
        .setFromAddress("from")
        .setToAddress("to")
        .setTimestamp("2020-01-01T00:00:00Z")
        .setTxnHash("xxx")
        .build();
        accountDAO.save(account);
        accountDAO.addTrasaction("foo2", transaction);
        Optional<Account> retrievedAccount = accountDAO.get("foo2");
        assertTrue(retrievedAccount.isPresent());
        assertTrue(retrievedAccount.get().getTransactions().contains(transaction));
    }
}
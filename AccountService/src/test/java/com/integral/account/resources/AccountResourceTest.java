package com.integral.account.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.integral.account.core.Account;
import com.integral.account.db.AccountDAO;

public class AccountResourceTest {

    private AccountResource accountResource;
    private AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        accountDAO = new AccountDAO();
        accountResource = new AccountResource(accountDAO);
    }

    @Test
    public void testGetAccount() {
        Account account = Account.builder().setAccountId("foo1").setAccountAddress("bar1").build();
        accountDAO.save(account);
        
        Account retrievedAccount = accountResource.getAccount("foo1");
        assertNotNull(retrievedAccount);
        assertEquals(account, retrievedAccount);
    }

    @Test
    public void testCreateAccount() {
        Account createdAccount = accountResource.createAccount("foo2");
        assertNotNull(createdAccount);
        assertEquals("foo2", createdAccount.getAccountId());
        
        Optional<Account> retrievedAccount = accountDAO.get("foo2");
        assertTrue(retrievedAccount.isPresent());
        assertEquals(createdAccount, retrievedAccount.get());
    }
}
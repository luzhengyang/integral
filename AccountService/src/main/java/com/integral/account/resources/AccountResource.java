package com.integral.account.resources;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.integral.account.core.Account;
import com.integral.account.core.Transaction;
import com.integral.account.db.AccountDAO;

@Path("/accounts/{accountId}")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    private final AccountDAO accountDAO;

    

    @Inject
    public AccountResource(AccountDAO accountDAO) {
        this.accountDAO = Objects.requireNonNull(accountDAO, "accountDAO cannot be null");
    }

    @GET
    public Account getAccount(@PathParam("accountId") String accountId) {
        return accountDAO.get(accountId).orElse(null);
    }

    @POST
    public Account createAccount(@PathParam("accountId") String accountId) {
        Set<Transaction> transactions = new HashSet<>();

        Account account = Account.builder()
        .setAccountId(accountId)
        .setAccountAddress("0x9aa99c23f67c81701c772b106b4f83f6e858dd2e")
        .setBalance(0.0)
        .setSymbol("ETH")
        .setTransactions(transactions)
        .build();

        accountDAO.save(account);
        return account;
    }
}

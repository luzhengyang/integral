package com.integral.account.db;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.inject.Singleton;
import com.integral.account.core.Account;
import com.integral.account.core.Transaction;

@Singleton
public class AccountDAO {

    private Set<Account> accounts = new HashSet<>();

    public AccountDAO() {
    }

    public Set<Account> getAll() {
        return accounts;
    }

    public Optional<Account> get(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

    public void save(Account account) {
        accounts.add(account);
    }

    public void addTrasaction(String accountId, Transaction transaction) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                account.getTransactions().add(transaction);
            }
        }
    }
}
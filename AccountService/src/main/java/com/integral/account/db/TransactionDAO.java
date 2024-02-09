package com.integral.account.db;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.integral.account.core.Transaction;

@Singleton
public class TransactionDAO {

    private Set<Transaction> trasactions = new HashSet<>();

    private AccountDAO accountDAO;

    @Inject
    public TransactionDAO(AccountDAO accountDAO) {
        this.accountDAO = Objects.requireNonNull(accountDAO);
    }

    public List<Transaction> getTransactionsOfAccount(String accountId) {

        Set<Transaction> trasactionsOfAccount = new HashSet<>();

        for (Transaction trasaction : trasactions) {
            if (trasaction.getAccountId() != null && trasaction.getAccountId().equals(accountId)) {
                trasactionsOfAccount.add(trasaction);
            }
        }

        return trasactionsOfAccount.stream()
                .sorted((transaction1, transaction2) -> Instant.parse(transaction1.getTimestamp())
                        .compareTo(Instant.parse(transaction2.getTimestamp())))
                .collect(Collectors.toList());
    }

    public void save(Transaction transaction) {
        trasactions.add(transaction);
        accountDAO.addTrasaction(transaction.getAccountId(), transaction);
    }
}

package com.integral.account.guice;

import com.integral.account.db.AccountDAO;
import com.integral.account.db.TransactionDAO;

import io.dropwizard.Configuration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class GuiceModule extends DropwizardAwareModule<Configuration> {
    @Override
    protected void configure() {
        bind(AccountDAO.class);
        bind(TransactionDAO.class);
    }
}

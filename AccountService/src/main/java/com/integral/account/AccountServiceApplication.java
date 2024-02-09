package com.integral.account;

import com.integral.account.guice.GuiceModule;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class AccountServiceApplication extends Application<AccountServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AccountServiceApplication().run("server", "config.yml");
    }

    @Override
    public String getName() {
        return "AccountService";
    }

    @Override
    public void initialize(final Bootstrap<AccountServiceConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                        .enableAutoConfig(getClass().getPackage().getName())
                        .modules(new GuiceModule())
                        .build());
    }

    @Override
    public void run(final AccountServiceConfiguration configuration,
                    final Environment environment) {
    }

}

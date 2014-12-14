package griffio.expenses.configuration;

import com.codahale.metrics.health.HealthCheck;

public class MainHealth extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }
}


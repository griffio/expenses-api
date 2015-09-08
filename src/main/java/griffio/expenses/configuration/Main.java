package griffio.expenses.configuration;

import com.codahale.metrics.JmxReporter;
import griffio.expenses.resource.ExpensesRepository;
import griffio.expenses.resource.ExpensesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<MainConfig> {

  public static void main(String[] args) throws Exception {
    new Main().run("server");
  }

  @Override
  public String getName() {
    return "expenses-api";
  }

  @Override
  public void initialize(Bootstrap<MainConfig> bootstrap) {
  }

  @Override
  public void run(MainConfig configuration, Environment environment) throws Exception {
    JmxReporter.forRegistry(environment.metrics()).build().start();
    environment.healthChecks().register(getName(), new MainHealth());
    environment.jersey().register(new ExpensesResource(new ExpensesRepository()));
  }
}

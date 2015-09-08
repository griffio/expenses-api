package griffio.expenses;

import com.fasterxml.jackson.databind.ObjectMapper;
import griffio.expenses.resource.ExpensesRepository;
import griffio.expenses.resource.ExpensesResource;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static io.dropwizard.testing.FixtureHelpers.fixture;

public class ExpensesResourceTest {

  private static final ObjectMapper mapper = Jackson.newObjectMapper();
  private static final ExpensesRepository expenses = new ExpensesRepository();

  @ClassRule
  public static final ResourceTestRule resources = ResourceTestRule.builder()
      .addResource(new ExpensesResource(expenses))
      .build();

  private Expense expense;

  @Before
  public void setUp() throws Exception {
    expense = mapper.readValue(fixture("fixtures/expense.json"), Expense.class);
    expenses.update(expense);
  }

  @Test
  public void get_expenses() {

    List<Expense> expenses = resources.client()
        .target("/expenses")
        .request(MediaType.APPLICATION_JSON)
        .get(new GenericType<List<Expense>>() {
        });

    Assert.assertTrue(expenses.contains(expense));

  }

  @Test
  public void post_expense() throws Exception {

    resources.client()
        .target("/expenses")
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(expense, MediaType.APPLICATION_JSON));
  }

  @Test
  public void get_expense_by_id() throws Exception {

    Expense actual = resources.client()
        .target("/expenses/ids/" + expense.getId().id())
        .request(MediaType.APPLICATION_JSON)
        .get(Expense.class);

    Assert.assertEquals(expense, actual);
  }
}
package griffio.expenses;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class JsonFixturesTest {

  private static final ObjectMapper mapper = Jackson.newObjectMapper();

  final Identifier identifier = Identifier.create(UUID.fromString("97ac81fc-7fb4-11e4-b116-123b93f75cba"));
  final Currency currency = Currency.getInstance(Locale.US);
  final Description description = Description.create("Give me a reason");
  final LocalDate localDate = LocalDate.parse("2014-08-01");

  @Test
  public void uuid_serializes_from_json() throws Exception {
    Identifier expected = identifier;
    Identifier actual = mapper.readValue(fixture("fixtures/identifier.json"), Identifier.class);
    assertEquals(expected, actual);
  }

  @Test
  public void cash_serializes_from_json() throws Exception {
    Cash expected = Cash.create(currency, BigDecimal.TEN);
    Cash actual = mapper.readValue(fixture("fixtures/cash.json"), Cash.class);
    assertEquals(expected, actual);
  }

  @Test
  public void description_serializes_from_json() throws Exception {
    Description expected = description;
    Description actual = mapper.readValue(fixture("fixtures/description.json"), Description.class);
    assertEquals(expected, actual);
  }

  @Test
  public void expense_serializes_to_json() throws IOException {
    Expense expected = new ExpenseBuilder()
        .id(identifier)
        .cash(Cash.create(currency, BigDecimal.TEN))
        .date(localDate)
        .reason(description).build();
    Expense actual = mapper.readValue(mapper.writeValueAsString(expected), Expense.class);
    assertEquals(expected, actual);
  }

}

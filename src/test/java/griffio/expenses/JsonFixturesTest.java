package griffio.expenses;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

public class JsonFixturesTest {

    private static final ObjectMapper mapper = Jackson.newObjectMapper();

    @Test
    public void amount_serializes_from_json() throws Exception {

        Cash expected = Cash.create(Currency.getInstance(Locale.US), BigDecimal.TEN);
        Cash actual = mapper.readValue(fixture("fixtures/cash.json"), Cash.class);
        assertEquals(expected, actual);
    }

    @Test
    public void description_serializes_from_json() throws Exception {

        Description expected = Description.create("Give me a reason");
        Description actual = mapper.readValue(fixture("fixtures/description.json"), Description.class);
        assertEquals(expected, actual);
    }

    @Test
    public void expense_serializes_to_json() throws IOException {

        String expected = fixture("fixtures/expense.json");
        String actual = mapper.writeValueAsString(mapper.readValue(expected, Expense.class));
        assertEquals(expected, actual);
    }

}

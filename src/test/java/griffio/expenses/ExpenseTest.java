package griffio.expenses;

import com.google.common.testing.EqualsTester;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

public class ExpenseTest {

    private ExpenseBuilder builder;

    @Before
    public void setUp() throws Exception {

        builder = new ExpenseBuilder()
                .cash(Cash.create(Currency.getInstance(Locale.US), BigDecimal.TEN))
                .date(LocalDate.parse("1999-03-01"))
                .reason(Description.create("Give me a reason"));
    }

    @Test
    public void identity_by_id_hashcode_equals() {

        Expense a1 = builder.id(Identifier.create(UUID.randomUUID())).createExpense();
        Expense a2 = builder.reason(Description.create("id as A1")).createExpense();

        Expense b1 = builder.id(Identifier.create(UUID.randomUUID())).createExpense();
        Expense b2 = builder.reason(Description.create("id as B1")).createExpense();

        new EqualsTester()
                .addEqualityGroup(a1, a2)
                .addEqualityGroup(b1, b2)
                .testEquals();
    }

}

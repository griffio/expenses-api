package griffio.expenses;

import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
import com.google.common.truth.Truth;
import com.mysema.query.collections.CollQuery;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static com.mysema.query.collections.CollQueryFactory.from;
import static griffio.expenses.QExpense.*;

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

    Expense a1 = builder.id(Identifier.create(UUID.randomUUID())).build();
    Expense a2 = builder.reason(Description.create("id as A1")).build();

    Expense b1 = builder.id(Identifier.create(UUID.randomUUID())).build();
    Expense b2 = builder.reason(Description.create("id as B1")).build();

    new EqualsTester()
        .addEqualityGroup(a1, a2)
        .addEqualityGroup(b1, b2)
        .testEquals();
  }

  @Test
  public void expense_query() {

    Cash tenUSD = Cash.create(Currency.getInstance("USD"), BigDecimal.TEN);
    Cash oneUSD = Cash.create(Currency.getInstance("USD"), BigDecimal.ONE);

    Expense a1 = builder.cash(tenUSD).reason(Description.create("a1")).build();
    Expense a2 = builder.cash(tenUSD).reason(Description.create("a2")).build();
    Expense a3 = builder.cash(tenUSD).reason(Description.create("a3")).build();
    Expense a4 = builder.cash(oneUSD).reason(Description.create("a4")).build();

    List<Expense> expenses = Lists.newArrayList(a1, a2, a3, a4);

    List<Expense> cheapExpenses =
        from(expense, expenses)
        .where(expense.cash.eq(oneUSD))
        .list(expense);

    Truth.assertThat(cheapExpenses.size()).is(1);

  }

}

package griffio.expenses;

import org.joda.time.LocalDate;

import java.util.UUID;

public class ExpenseBuilder {

  private Identifier identifier;
  private Description reason;
  private Cash cash;
  private LocalDate date;

  public ExpenseBuilder() {
    this.identifier = Identifier.create(UUID.randomUUID());
  }

  public ExpenseBuilder id(Identifier identifier) {
    this.identifier = identifier;
    return this;
  }

  public ExpenseBuilder reason(Description reason) {
    this.reason = reason;
    return this;
  }

  public ExpenseBuilder cash(Cash cash) {
    this.cash = cash;
    return this;
  }

  public ExpenseBuilder date(LocalDate date) {
    this.date = date;
    return this;
  }

  public Expense build() {
    return new Expense(identifier, reason, cash, date);
  }
}
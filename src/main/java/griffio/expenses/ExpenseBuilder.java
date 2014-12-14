package griffio.expenses;

import org.joda.time.LocalDate;

import java.util.Optional;
import java.util.UUID;

public class ExpenseBuilder {

    private Optional<Identifier> identifier;
    private Description reason;
    private Cash cash;
    private LocalDate date;

    public ExpenseBuilder() {
        this.identifier = Optional.of(Identifier.create(UUID.randomUUID()));
    }

    public ExpenseBuilder id(Identifier identifier) {
        this.identifier = Optional.of(identifier);
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

    public Expense createExpense() {
        return new Expense(identifier.get(), reason, cash, date);
    }
}
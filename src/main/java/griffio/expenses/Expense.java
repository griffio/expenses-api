package griffio.expenses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mysema.query.annotations.QueryEntity;
import griffio.expenses.resource.ExpenseJsonDeSerializer;
import griffio.expenses.resource.ExpenseJsonSerializer;
import org.joda.time.LocalDate;

import java.util.Objects;

@QueryEntity
@JsonSerialize(using = ExpenseJsonSerializer.class)
@JsonDeserialize(using = ExpenseJsonDeSerializer.class)
public final class Expense {

  private final Identifier id;
  private final Description reason;
  private final Cash cash;
  private final LocalDate date;

  @JsonCreator
  public Expense(Identifier id, Description reason, Cash cash, LocalDate date) {
    this.id = id;
    this.reason = reason;
    this.cash = cash;
    this.date = date;
  }

  public Identifier getId() {
    return id;
  }

  public Cash getCash() {
    return cash;
  }

  public LocalDate getDate() {
    return date;
  }

  public Description getReason() {
    return reason;
  }

  @Override
  public boolean equals(Object object) {

    if (object instanceof Expense) {
      Expense that = (Expense) object;
      return Objects.equals(this.getId(), that.getId());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Expense{" +
        "id=" + id +
        ", reason=" + reason +
        ", cash=" + cash +
        ", date=" + date +
        '}';
  }
}
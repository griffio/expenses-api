
package griffio.expenses;

import java.math.BigDecimal;
import java.util.Currency;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Cash extends Cash {

  private final Currency currency;
  private final BigDecimal amount;

  AutoValue_Cash(
      Currency currency,
      BigDecimal amount) {
    if (currency == null) {
      throw new NullPointerException("Null currency");
    }
    this.currency = currency;
    if (amount == null) {
      throw new NullPointerException("Null amount");
    }
    this.amount = amount;
  }

  @Override
  public Currency currency() {
    return currency;
  }

  @Override
  public BigDecimal amount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Cash{"
        + "currency=" + currency + ", "
        + "amount=" + amount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Cash) {
      Cash that = (Cash) o;
      return (this.currency.equals(that.currency()))
           && (this.amount.equals(that.amount()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= currency.hashCode();
    h *= 1000003;
    h ^= amount.hashCode();
    return h;
  }

}

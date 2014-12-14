package griffio.expenses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@AutoValue
public abstract class Cash {

    public abstract Currency currency();
    public abstract BigDecimal amount();

    @JsonCreator
    public static Cash create(@JsonProperty("currency") Currency currency, @JsonProperty("cash") BigDecimal value) {
        return new AutoValue_Cash(currency, value.setScale(2, RoundingMode.HALF_UP));
    }

}

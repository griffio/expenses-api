package griffio.expenses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.UUID;

@AutoValue
public abstract class Identifier<T> {
    public abstract T id();

    @JsonCreator
    public static Identifier create(@JsonProperty("id") UUID id) {
        return new AutoValue_Identifier<>(id);
    }

}

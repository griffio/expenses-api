package griffio.expenses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.base.CharMatcher;

@AutoValue
public abstract class Description {

  public abstract String text();

  @JsonCreator
  public static Description create(@JsonProperty("text") String text) {
    return new AutoValue_Description(CharMatcher.JAVA_LETTER_OR_DIGIT.or(CharMatcher.WHITESPACE).retainFrom(text));
  }

}

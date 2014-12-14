
package griffio.expenses;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Description extends Description {

  private final String text;

  AutoValue_Description(
      String text) {
    if (text == null) {
      throw new NullPointerException("Null text");
    }
    this.text = text;
  }

  @Override
  public String text() {
    return text;
  }

  @Override
  public String toString() {
    return "Description{"
        + "text=" + text
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Description) {
      Description that = (Description) o;
      return (this.text.equals(that.text()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= text.hashCode();
    return h;
  }

}

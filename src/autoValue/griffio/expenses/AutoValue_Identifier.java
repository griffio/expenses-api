
package griffio.expenses;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Identifier<T> extends Identifier<T> {

  private final T id;

  AutoValue_Identifier(
      T id) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
  }

  @Override
  public T id() {
    return id;
  }

  @Override
  public String toString() {
    return "Identifier{"
        + "id=" + id
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Identifier) {
      Identifier<?> that = (Identifier<?>) o;
      return (this.id.equals(that.id()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= id.hashCode();
    return h;
  }

}

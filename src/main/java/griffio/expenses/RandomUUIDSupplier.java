package griffio.expenses;

import java.util.UUID;
import java.util.function.Supplier;

public class RandomUUIDSupplier implements Supplier<UUID> {
  @Override
  public UUID get() {
    return UUID.randomUUID();
  }
}

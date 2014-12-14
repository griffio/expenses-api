package griffio.expenses.resource;

import griffio.expenses.Identifier;
import io.dropwizard.jersey.params.AbstractParam;

import java.util.UUID;

public final class UUIDParam extends AbstractParam<Identifier> {

    public UUIDParam(String input) {
        super(input);
    }

    @Override
    protected Identifier parse(String input) throws Exception {
        return Identifier.create(UUID.fromString(input));
    }
}

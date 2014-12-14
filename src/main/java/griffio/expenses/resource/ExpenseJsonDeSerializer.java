package griffio.expenses.resource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import griffio.expenses.Cash;
import griffio.expenses.Description;
import griffio.expenses.Expense;
import griffio.expenses.ExpenseBuilder;
import griffio.expenses.Identifier;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.Currency;
import java.util.UUID;
/**
 * Conversion to Expense performed in one place for incoming io
 * {"id":"97ac81fc-7fb4-11e4-b116-123b93f75cba","reason":"rhubarb and sausages","cash":"1234.00","date":"2014-08-01"}
 */
public class ExpenseJsonDeSerializer extends JsonDeserializer<Expense> {

    @Override
    public Expense deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        Identifier uuid = Identifier.create(UUID.fromString(node.get("id").asText()));
        LocalDate isoDate = LocalDate.parse(node.get("date").asText());
        Cash cash = Cash.create(Currency.getInstance(ctxt.getLocale()), node.get("cash").decimalValue());
        Description reason = Description.create(node.get("reason").asText());
        return new ExpenseBuilder().id(uuid).date(isoDate).cash(cash).reason(reason).createExpense();
    }

}

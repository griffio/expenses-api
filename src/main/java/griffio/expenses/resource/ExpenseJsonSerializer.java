package griffio.expenses.resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import griffio.expenses.Expense;

import java.io.IOException;

public class ExpenseJsonSerializer extends JsonSerializer<Expense> {

    @Override
    public void serialize(Expense expense, JsonGenerator json, SerializerProvider provider) throws IOException {
        json.writeStartObject();
        json.writeObjectField("id", expense.getId().id());
        json.writeStringField("reason", expense.getReason().text());
        json.writeObjectField("cash", expense.getCash().amount());
        json.writeStringField("date", expense.getDate().toString());
        json.writeEndObject();
    }

}

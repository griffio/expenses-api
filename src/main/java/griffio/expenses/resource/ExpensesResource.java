package griffio.expenses.resource;

import com.codahale.metrics.annotation.Timed;
import griffio.expenses.Expense;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/expenses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpensesResource {

  private ExpensesRepository repository;

  public ExpensesResource(ExpensesRepository repository) {
    this.repository = repository;
  }

  @GET
  @Timed
  public List<Expense> list() {
    return repository.getExpenses();
  }

  @POST
  @Timed
  public void post(Expense expense) {
    repository.create(expense);
  }

  @GET
  @Timed
  @Path("/ids/{id}")
  public Expense get(@PathParam("id") UUIDParam id) {
    return repository.findByKey(id.get()).get();
  }

}

package griffio.expenses.resource;

import com.google.common.collect.Lists;
import griffio.expenses.Expense;
import griffio.expenses.Identifier;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ExpensesRepository {

  private ConcurrentHashMap<Identifier, Expense> expenses = new ConcurrentHashMap<>();

  public ExpensesRepository() {
  }

  public Optional<Expense> findByKey(Identifier key) {
    return Optional.of(expenses.get(key));
  }

  public List<Expense> getExpenses() {
    return Lists.newArrayList(expenses.values());
  }

  public Collection<Expense> create(Expense expense) {
    expenses.put(expense.getId(), expense);
    return getExpenses();
  }

  public Collection<Expense> update(Expense expense) {
    expenses.put(expense.getId(), expense);
    return getExpenses();
  }

}

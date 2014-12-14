package griffio.expenses;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QExpense is a Querydsl query type for Expense
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QExpense extends EntityPathBase<Expense> {

    private static final long serialVersionUID = -197988017L;

    public static final QExpense expense = new QExpense("expense");

    public final SimplePath<Cash> cash = createSimple("cash", Cash.class);

    public final DatePath<org.joda.time.LocalDate> date = createDate("date", org.joda.time.LocalDate.class);

    public final SimplePath<Identifier> id = createSimple("id", Identifier.class);

    public final SimplePath<Description> reason = createSimple("reason", Description.class);

    public QExpense(String variable) {
        super(Expense.class, forVariable(variable));
    }

    public QExpense(Path<Expense> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExpense(PathMetadata<?> metadata) {
        super(Expense.class, metadata);
    }

}


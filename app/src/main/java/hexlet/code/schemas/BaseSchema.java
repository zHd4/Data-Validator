package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> conditions = new ArrayList<>();

    protected final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }

    public final boolean isValid(Object value) {
        for (Predicate<Object> condition : conditions) {
            if (!condition.test(value)) {
                return false;
            }
        }

        return true;
    }
}

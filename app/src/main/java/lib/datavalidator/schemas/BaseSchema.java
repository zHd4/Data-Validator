package lib.datavalidator.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> conditions = new HashMap<>();

    protected final void addCondition(String name, Predicate<Object> condition) {
        conditions.put(name, condition);
    }

    public final boolean isValid(Object value) {
        for (Predicate<Object> condition : conditions.values()) {
            if (!condition.test(value)) {
                return false;
            }
        }

        return true;
    }
}

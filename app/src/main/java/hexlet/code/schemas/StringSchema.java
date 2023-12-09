package hexlet.code.schemas;

import java.util.function.Predicate;

@SuppressWarnings("UnusedReturnValue")
public class StringSchema extends Schema {
    public final StringSchema required() {
        Predicate<Object> condition = value -> {
            if (isString(value)) {
                return !((String) value).isBlank();
            }
            return false;
        };

        addCondition(condition);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<Object> condition = value -> {
            if (isString(value)) {
                String str = (String) value;
                return str.length() >= length;
            }
            return false;
        };

        addCondition(condition);
        return this;
    }

    public final StringSchema contains(String substring) {
        Predicate<Object> condition = value -> {
            if (isString(value)) {
                String str = (String) value;
                return str.contains(substring);
            }

            return false;
        };

        addCondition(condition);
        return this;
    }

    private boolean isString(Object object) {
        return object instanceof String;
    }
}

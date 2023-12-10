package hexlet.code.schemas;

import java.util.Objects;

@SuppressWarnings("UnusedReturnValue")
public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        addCondition(Objects::nonNull);
        return this;
    }

    public final NumberSchema positive() {
        addCondition(value -> {
            if (Objects.nonNull(value)) {
                if (isInteger(value)) {
                    return (int) value > 0;
                }
            } else {
                return true;
            }
            return false;
        });

        return this;
    }

    public final NumberSchema range(int start, int end) {
        addCondition(value -> {
            int i = value != null ? (int) value : 0;
            return i >= start && i <= end;
        });

        return this;
    }

    private boolean isInteger(Object object) {
        return object instanceof Integer;
    }
}

package com.zhd4.lib.datavalidator.schemas;

import java.util.Objects;
import java.util.function.Predicate;

@SuppressWarnings("UnusedReturnValue")
public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        addCondition("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> condition = value -> {
            if (Objects.nonNull(value)) {
                if (isInteger(value)) {
                    return (int) value > 0;
                }
            } else {
                return true;
            }
            return false;
        };

        addCondition("positive", condition);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Object> condition = value -> {
            int i = value != null ? (int) value : 0;
            return i >= start && i <= end;
        };

        addCondition("range", condition);
        return this;
    }

    private boolean isInteger(Object object) {
        return object instanceof Integer;
    }
}

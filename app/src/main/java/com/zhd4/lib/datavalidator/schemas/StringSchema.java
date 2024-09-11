package com.zhd4.lib.datavalidator.schemas;

import java.util.function.Predicate;

@SuppressWarnings("UnusedReturnValue")
public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        Predicate<Object> condition = value -> {
            if (isString(value)) {
                return !((String) value).isBlank();
            }
            return false;
        };

        addCondition("required", condition);
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

        addCondition("minLength", condition);
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

        addCondition("contains", condition);

        return this;
    }

    private boolean isString(Object object) {
        return object instanceof String;
    }
}

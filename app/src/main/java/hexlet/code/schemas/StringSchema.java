package hexlet.code.schemas;

@SuppressWarnings("UnusedReturnValue")
public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        addCondition(value -> {
            if (isString(value)) {
                return !((String) value).isBlank();
            }
            return false;
        });

        return this;
    }

    public final StringSchema minLength(int length) {
        addCondition(value -> {
            if (isString(value)) {
                String str = (String) value;
                return str.length() >= length;
            }
            return false;
        });

        return this;
    }

    public final StringSchema contains(String substring) {
        addCondition(value -> {
            if (isString(value)) {
                String str = (String) value;
                return str.contains(substring);
            }
            return false;
        });

        return this;
    }

    private boolean isString(Object object) {
        return object instanceof String;
    }
}

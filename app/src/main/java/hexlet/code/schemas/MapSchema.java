package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

@SuppressWarnings("UnusedReturnValue")
public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addCondition(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition(entity -> ((Map<?, ?>) entity).size() == size);
        return this;
    }
}

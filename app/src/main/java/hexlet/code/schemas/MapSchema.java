package hexlet.code.schemas;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

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

    @SuppressWarnings("unchecked")
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCondition(data -> {
            Map<String, Object> map = (Map<String, Object>) data;

            Predicate<Map.Entry<String, Object>> isNotValid = entry -> {
                BaseSchema schema = schemas.get(entry.getKey());
                return !schema.isValid(entry.getValue());
            };

            List<Map.Entry<String, Object>> notValid = map.entrySet()
                    .stream()
                    .filter(isNotValid)
                    .toList();

            return notValid.isEmpty();
        });

        return this;
    }
}
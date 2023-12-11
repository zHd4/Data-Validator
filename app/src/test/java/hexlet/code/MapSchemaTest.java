package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {
    @Test
    public void testSchema() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();

        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        Assertions.assertTrue(schema.isValid(data));

        schema.sizeof(2);
        Assertions.assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));
    }
}

package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {
    @Test
    public void testRequiredAndSizeof() {
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

    @Test
    public void testShape() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();

        human1.put("name", "Kolya");
        human1.put("age", 100);

        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();

        human2.put("name", "Maya");
        human2.put("age", null);

        Assertions.assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();

        human3.put("name", "");
        human3.put("age", null);

        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();

        human4.put("name", "Valya");
        human4.put("age", -5);

        Assertions.assertFalse(schema.isValid(human4));
    }

    @Test
    public void testShape2() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("title", validator.string().required().minLength(8).contains("island"));
        schemas.put("text", validator.string().required().minLength(20));
        schemas.put("number", validator.number().positive());

        schema.shape(schemas);

        Map<String, Object> article1 = new HashMap<>();

        article1.put("title", "Santorini islands");
        article1.put("text", "Lorem ipsum dolor sit amet");
        article1.put("number", 1); //true

        Assertions.assertTrue(schema.isValid(article1));

        Map<String, Object> article2 = new HashMap<>();

        article2.put("title", "Mauritius islands");
        article2.put("text", "Donec venenatis mauris");
        article2.put("number", 2); //true

        Assertions.assertTrue(schema.isValid(article2));

        Map<String, Object> article3 = new HashMap<>();

        article3.put("title", "Madagascar");
        article3.put("text", "Donec venenatis mauris");
        article3.put("number", 2); //false

        Assertions.assertFalse(schema.isValid(article3));

        Map<String, Object> article4 = new HashMap<>();

        article4.put("title", "island");
        article4.put("text", "Donec venenatis mauris");
        article4.put("number", 2); //false

        Assertions.assertFalse(schema.isValid(article4));

        Map<String, Object> article5 = new HashMap<>();

        article5.put("title", "Palawan islands");
        article5.put("text", "Donec");
        article5.put("number", 2); //false

        Assertions.assertFalse(schema.isValid(article5));

        Map<String, Object> article6 = new HashMap<>();

        article6.put("title", "Bora Bora islands");
        article6.put("text", "Donec venenatis mauris");
        article6.put("number", 0); //false

        Assertions.assertFalse(schema.isValid(article6));
    }
}

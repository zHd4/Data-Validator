package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    private static final int TEST_INT_VALUE = 5;
    private static final int MIN_LENGTH = 10;

    @Test
    public void testRequired() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid(""));
        Assertions.assertFalse(schema.isValid(TEST_INT_VALUE));

        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void testMinLength() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

        schema.minLength(MIN_LENGTH);

        Assertions.assertTrue(schema.isValid("what does the fox say"));

        Assertions.assertFalse(schema.isValid("what"));
        Assertions.assertFalse(schema.isValid(TEST_INT_VALUE));

        Assertions.assertFalse(schema.isValid("w"));
        Assertions.assertFalse(schema.isValid("what does"));
    }

    @Test
    public void testContains() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

        Assertions.assertTrue(schema.contains("wh").isValid("what does the fox say"));
        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));

        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        Assertions.assertFalse(schema.isValid("what does the fox say"));
    }
}

package com.zhd4.lib.datavalidator;

import com.zhd4.lib.datavalidator.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    @Test
    public void testSchema() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();

        Assertions.assertTrue(schema.isValid(null));
        Assertions.assertTrue(schema.positive().isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid("5"));
        Assertions.assertTrue(schema.isValid(10));

        Assertions.assertFalse(schema.isValid(-10));
        Assertions.assertFalse(schema.isValid(0));

        schema.range(5, 10);

        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertTrue(schema.isValid(10));

        Assertions.assertFalse(schema.isValid(4));
        Assertions.assertFalse(schema.isValid(11));
    }
}

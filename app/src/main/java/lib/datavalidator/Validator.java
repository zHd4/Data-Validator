package lib.datavalidator;

import lib.datavalidator.schemas.MapSchema;
import lib.datavalidator.schemas.NumberSchema;
import lib.datavalidator.schemas.StringSchema;

public final class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }
}

package com.zhd4.lib.datavalidator;

import com.zhd4.lib.datavalidator.schemas.MapSchema;
import com.zhd4.lib.datavalidator.schemas.NumberSchema;
import com.zhd4.lib.datavalidator.schemas.StringSchema;

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

### Data Validator Library
[![Java CI](https://github.com/zHd4/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/zHd4/java-project-78/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/zHd4/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/b3fccbe62b2f05ce0246/maintainability" /></a>
<a href="https://codeclimate.com/github/zHd4/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/b3fccbe62b2f05ce0246/test_coverage" /></a>

A data validator is a library that can be used to check the correctness of any data. There are many such libraries in every programming language, because almost all programs work with external data that need to be checked for correctness. First of all, we are talking about form data filled in by users.

Example:
```java
import com.zhd4.lib.datavalidator.Validator;
import com.zhd4.lib.datavalidator.schemas.StringSchema;
import com.zhd4.lib.datavalidator.schemas.NumberSchema;
import com.zhd4.lib.datavalidator.schemas.MapSchema;
import com.zhd4.lib.datavalidator.schemas.BaseSchema;

Validator v = new Validator();

// Strings
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with support for structure checking
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
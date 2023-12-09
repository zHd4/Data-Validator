package hexlet.code.schemas;

import java.util.function.Predicate;

class Condition {
    private ConditionName name;
    private Predicate<Object> event;

    public Condition(ConditionName name, Predicate<Object> event) {
        this.name = name;
        this.event = event;
    }

    public ConditionName getName() {
        return name;
    }

    public Predicate<Object> getEvent() {
        return event;
    }
}

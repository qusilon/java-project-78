package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        limitations.put("required", Objects::isNull);
        return this;
    }

    public NumberSchema positive() {
        limitations.put("positive", content -> content == null || content <= 0);
        return this;
    }

    public NumberSchema range(int first, int end) {
        limitations.put("range", content -> content < first || content > end);
        return this;
    }
}

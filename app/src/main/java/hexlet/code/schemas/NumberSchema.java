package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class NumberSchema {

    private Map<String, Predicate<Integer>> limitations = new HashMap<>();

    public NumberSchema required() {
        limitations.put("required", content -> content == null || content.equals(""));
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

    public boolean isValid(Integer content) {
        if (content == null && !limitations.containsKey("required")) {
            return true;
        }
        for (Predicate<Integer> limitation : limitations.values()) {
            if (limitation.test(content)) {
                return false;
            }
        }
        return true;
    }
}

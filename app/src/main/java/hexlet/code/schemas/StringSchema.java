package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {

    private Map<String, Predicate<String>> limitations = new HashMap<>();

    public StringSchema required() {
        limitations.put("required", content -> content == null || content.equals(""));
        return this;
    }

    public StringSchema minLength(int minLength) {
        limitations.put("minLength", content -> content.length() < minLength);
        return this;
    }

    public StringSchema contains(String text) {
        limitations.put("contains", content -> !content.contains(text));
        return this;
    }


    public boolean isValid(String content) {
        for (Predicate<String> limitation : limitations.values()) {
            if (limitation.test(content)) {
                return false;
            }
        }
        return true;
    }
}

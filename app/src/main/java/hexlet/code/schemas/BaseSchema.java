package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> limitations = new HashMap<>();

    public boolean isValid(T content) {
        if (content == null && !limitations.containsKey("required")) {
            return true;
        }
        for (Predicate<T> limitation : limitations.values()) {
            if (limitation.test(content)) {
                return false;
            }
        }
        return true;
    }
}

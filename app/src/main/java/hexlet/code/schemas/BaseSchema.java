package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>>  limitations;

    public void isValid() {

    }
}

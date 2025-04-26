package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        limitations.put("required", Objects::isNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        limitations.put("sizeof", content -> content.size() != size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        limitations.put("shape", content -> {
            for (var entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                if (!schema.isValid((T) content.get(key))) {
                    return true;
                }
            }
            return false;
        });
        return this;
    }
}

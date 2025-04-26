package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        limitations.put("required", content -> content == null);
        return this;
    }

    public MapSchema sizeof(int size) {
        limitations.put("sizeof", content -> content.size() != size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        limitations.put("shape", content -> {
            for (String key : schemas.keySet()) {
                if (!schemas.get(key).isValid((T) content.get(key))) {
                    return true;
                }
            }
            return false;
        });
        return this;
    }
}

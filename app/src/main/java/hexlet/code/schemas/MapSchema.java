package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

//    public MapSchema required() {
//        limitations.put("required", content -> content == null);
//        return this;
//    }

    public MapSchema sizeof(int size) {
        limitations.put("sizeof", content -> content.size() != size);
        return this;
    }

}

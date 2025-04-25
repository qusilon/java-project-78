package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

//    public NumberSchema required() {
//        limitations.put("required", content -> content == null);
//        return this;
//    }

    public NumberSchema positive() {
        limitations.put("positive", content -> content == null || content <= 0);
        return this;
    }

    public NumberSchema range(int first, int end) {
        limitations.put("range", content -> content < first || content > end);
        return this;
    }

}

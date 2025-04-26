package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        limitations.put("required", content -> content == null || content.equals(""));
        return this;
    }

    public StringSchema minLength(int minLength) {
        limitations.put("minLength", content -> content == null || content.length() < minLength);
        return this;
    }

    public StringSchema contains(String text) {
        limitations.put("contains", content -> !content.contains(text));
        return this;
    }
}

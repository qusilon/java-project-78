package hexlet.code.schemas;

public class StringSchema {
    private boolean requiredLimitation = false;
    private int minLengthLimitation = -1;
    private String containsLimitation;

    public StringSchema required() {
        requiredLimitation = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        minLengthLimitation = minLength;
        return this;
    }

    public StringSchema contains(String text) {
        containsLimitation = text;
        return this;
    }


    public boolean isValid(String content) {
        if (isMinLengthOn()) {
            if (content.length() < minLengthLimitation) {
                return false;
            }
        }

        if (requiredLimitation) {
            if (content == null || content.equals("")) {
                return false;
            }
        }

        if (isContainsLimitation()) {
            if (!content.contains(containsLimitation)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMinLengthOn() {
        return minLengthLimitation > -1;
    }

    private boolean isContainsLimitation() {
        return containsLimitation != null;
    }
}

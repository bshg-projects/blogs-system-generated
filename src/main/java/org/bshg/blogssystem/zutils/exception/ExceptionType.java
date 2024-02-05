package org.bshg.blogssystem.zutils.exception;

public enum ExceptionType {
    ERROR("errors"), WARNING("warning"),

    NOT_FOUND_ERROR(ERROR.value + ".notFound");
// add your other types here...

    private final String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

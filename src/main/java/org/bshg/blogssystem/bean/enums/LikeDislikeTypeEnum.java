package org.bshg.blogssystem.bean.enums;

public enum LikeDislikeTypeEnum {
    LIKE("LIKE"),
    DISLIKE("DISLIKE"),
    ;
    private final String value;

    LikeDislikeTypeEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
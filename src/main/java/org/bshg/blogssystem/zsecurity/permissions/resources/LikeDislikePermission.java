package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum LikeDislikePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    LikeDislikePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "likeDislike";
    }

    @Override
    public String authority() {
        return value;
    }
}

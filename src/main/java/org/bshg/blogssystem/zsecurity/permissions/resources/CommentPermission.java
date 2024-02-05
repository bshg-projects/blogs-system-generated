package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum CommentPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CommentPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "comment";
    }

    @Override
    public String authority() {
        return value;
    }
}

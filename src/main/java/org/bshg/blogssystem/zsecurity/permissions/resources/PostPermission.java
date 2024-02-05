package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum PostPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    PostPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "post";
    }

    @Override
    public String authority() {
        return value;
    }
}

package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum TagPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    TagPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "tag";
    }

    @Override
    public String authority() {
        return value;
    }
}

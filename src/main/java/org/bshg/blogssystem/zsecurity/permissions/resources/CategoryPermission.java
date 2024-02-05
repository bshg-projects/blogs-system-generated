package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum CategoryPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CategoryPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "category";
    }

    @Override
    public String authority() {
        return value;
    }
}

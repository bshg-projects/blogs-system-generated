package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum PagePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    PagePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "page";
    }

    @Override
    public String authority() {
        return value;
    }
}

package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum CostumerPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CostumerPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "costumer";
    }

    @Override
    public String authority() {
        return value;
    }
}

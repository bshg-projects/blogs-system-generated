package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum UserProfilePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    UserProfilePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "userProfile";
    }

    @Override
    public String authority() {
        return value;
    }
}

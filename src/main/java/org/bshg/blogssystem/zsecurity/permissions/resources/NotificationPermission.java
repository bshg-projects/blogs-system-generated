package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum NotificationPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    NotificationPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "notification";
    }

    @Override
    public String authority() {
        return value;
    }
}

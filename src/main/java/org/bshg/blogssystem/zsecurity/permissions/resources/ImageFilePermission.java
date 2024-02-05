package org.bshg.blogssystem.zsecurity.permissions.resources;

import org.bshg.blogssystem.zsecurity.permissions.PermissionResource;

public enum ImageFilePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ImageFilePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "imageFile";
    }

    @Override
    public String authority() {
        return value;
    }
}

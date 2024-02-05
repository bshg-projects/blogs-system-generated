package org.bshg.blogssystem.zsecurity.permissions;

import org.bshg.blogssystem.zsecurity.bean.Permission;
import org.bshg.blogssystem.zsecurity.bean.Role;
import org.bshg.blogssystem.zsecurity.permissions.resources.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleEnum {
    ADMIN(
            UserPermission.values(),
            RolePermission.values(),
            AdminPermission.values(),
            CostumerPermission.values(),
            PostPermission.values(),
            CommentPermission.values(),
            TagPermission.values(),
            CategoryPermission.values(),
            ImageFilePermission.values(),
            LikeDislikePermission.values(),
            NotificationPermission.values(),
            UserProfilePermission.values(),
            PagePermission.values()
    ),
    COSTUMER(
            AdminPermission.READ,
            CostumerPermission.READ,
            PostPermission.READ,
            CommentPermission.READ,
            TagPermission.READ,
            CategoryPermission.READ,
            ImageFilePermission.READ,
            LikeDislikePermission.READ,
            NotificationPermission.READ,
            UserProfilePermission.READ,
            PagePermission.READ
    ),
    ;
    private final Set<PermissionResource> permissions;

    RoleEnum(PermissionResource... permissions) {
        this.permissions = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(permissions)));
    }

    RoleEnum(Object... permissionsList) {
        this.permissions = Arrays.stream(permissionsList)
                .flatMap(o -> {
                    if (o instanceof PermissionResource[]) {
                        return Arrays.stream((PermissionResource[]) o);
                    } else if (o instanceof PermissionResource) {
                        return Arrays.stream(new PermissionResource[]{(PermissionResource) o});
                    } else {
                        throw new IllegalArgumentException("Unsupported type in permissionsList");
                    }
                }).collect(Collectors.toUnmodifiableSet());
    }

    /*RoleEnum(PermissionResource[]... permissionsList) {
    Set<PermissionResource> combinedPermissions = Arrays.stream(permissionsList)
    .flatMap(Arrays::stream)
    .collect(Collectors.toSet());
    this.permissions = Set.copyOf(combinedPermissions);
    }*/
    public Set<PermissionResource> getPermissions() {
        return permissions;
    }

    public Role getRole() {
        var result = new Role();
        result.setName(this.name());
        result.setPermissions(
                this.getPermissions().stream()
                        .map(p -> new Permission(p.authority()))
                        .collect(Collectors.toSet())
        );
        return result;
    }
}
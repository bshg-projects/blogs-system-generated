package org.bshg.blogssystem.zsecurity.config;

import org.bshg.blogssystem.zsecurity.permissions.RoleEnum;
import org.bshg.blogssystem.zsecurity.permissions.resources.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.springframework.http.HttpMethod.*;

public class RequestConfig {
    private RequestConfig() {
    }

    private static HttpSecurity http;

    public static void set(HttpSecurity http) throws Exception {
        if (RequestConfig.http == null) RequestConfig.http = http;
        adminAuthorizeHttpRequests();
        costumerAuthorizeHttpRequests();
        postAuthorizeHttpRequests();
        commentAuthorizeHttpRequests();
        tagAuthorizeHttpRequests();
        categoryAuthorizeHttpRequests();
        imageFileAuthorizeHttpRequests();
        likeDislikeAuthorizeHttpRequests();
        notificationAuthorizeHttpRequests();
        userProfileAuthorizeHttpRequests();
        pageAuthorizeHttpRequests();
        userAuthorizeHttpRequests();
        roleAuthorizeHttpRequests();
        defaultAuthorizeHttpRequests();
    }

    private static void userAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/user/**").hasAnyAuthority(UserPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/user/**").hasAnyAuthority(UserPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/user/**").hasAnyAuthority(UserPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/user/**").hasAnyAuthority(UserPermission.DELETE.authority())
                .requestMatchers("/api/v1/user/**").hasAnyRole(RoleEnum.ADMIN.name())
        );
    }

    private static void roleAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/role/**").hasAnyAuthority(RolePermission.READ.authority())
                .requestMatchers(POST, "/api/v1/role/**").hasAnyAuthority(RolePermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/role/**").hasAnyAuthority(RolePermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/role/**").hasAnyAuthority(RolePermission.DELETE.authority())
                .requestMatchers("/api/v1/role/**").hasAnyRole(RoleEnum.ADMIN.name())
        );
    }

    private static void adminAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/admin/**").hasAnyAuthority(AdminPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/admin/**").hasAnyAuthority(AdminPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/admin/**").hasAnyAuthority(AdminPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/admin/**").hasAnyAuthority(AdminPermission.DELETE.authority())
                .requestMatchers("/api/v1/admin/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void costumerAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/costumer/**").hasAnyAuthority(CostumerPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/costumer/**").hasAnyAuthority(CostumerPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/costumer/**").hasAnyAuthority(CostumerPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/costumer/**").hasAnyAuthority(CostumerPermission.DELETE.authority())
                .requestMatchers("/api/v1/costumer/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void postAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/post/**").hasAnyAuthority(PostPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/post/**").hasAnyAuthority(PostPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/post/**").hasAnyAuthority(PostPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/post/**").hasAnyAuthority(PostPermission.DELETE.authority())
                .requestMatchers("/api/v1/post/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void commentAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/comment/**").hasAnyAuthority(CommentPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/comment/**").hasAnyAuthority(CommentPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/comment/**").hasAnyAuthority(CommentPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/comment/**").hasAnyAuthority(CommentPermission.DELETE.authority())
                .requestMatchers("/api/v1/comment/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void tagAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/tag/**").hasAnyAuthority(TagPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/tag/**").hasAnyAuthority(TagPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/tag/**").hasAnyAuthority(TagPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/tag/**").hasAnyAuthority(TagPermission.DELETE.authority())
                .requestMatchers("/api/v1/tag/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void categoryAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/category/**").hasAnyAuthority(CategoryPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/category/**").hasAnyAuthority(CategoryPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/category/**").hasAnyAuthority(CategoryPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/category/**").hasAnyAuthority(CategoryPermission.DELETE.authority())
                .requestMatchers("/api/v1/category/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void imageFileAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/imagefile/**").hasAnyAuthority(ImageFilePermission.READ.authority())
                .requestMatchers(POST, "/api/v1/imagefile/**").hasAnyAuthority(ImageFilePermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/imagefile/**").hasAnyAuthority(ImageFilePermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/imagefile/**").hasAnyAuthority(ImageFilePermission.DELETE.authority())
                .requestMatchers("/api/v1/imagefile/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void likeDislikeAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/likedislike/**").hasAnyAuthority(LikeDislikePermission.READ.authority())
                .requestMatchers(POST, "/api/v1/likedislike/**").hasAnyAuthority(LikeDislikePermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/likedislike/**").hasAnyAuthority(LikeDislikePermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/likedislike/**").hasAnyAuthority(LikeDislikePermission.DELETE.authority())
                .requestMatchers("/api/v1/likedislike/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void notificationAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/notification/**").hasAnyAuthority(NotificationPermission.READ.authority())
                .requestMatchers(POST, "/api/v1/notification/**").hasAnyAuthority(NotificationPermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/notification/**").hasAnyAuthority(NotificationPermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/notification/**").hasAnyAuthority(NotificationPermission.DELETE.authority())
                .requestMatchers("/api/v1/notification/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void userProfileAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/userprofile/**").hasAnyAuthority(UserProfilePermission.READ.authority())
                .requestMatchers(POST, "/api/v1/userprofile/**").hasAnyAuthority(UserProfilePermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/userprofile/**").hasAnyAuthority(UserProfilePermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/userprofile/**").hasAnyAuthority(UserProfilePermission.DELETE.authority())
                .requestMatchers("/api/v1/userprofile/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void pageAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(GET, "/api/v1/page/**").hasAnyAuthority(PagePermission.READ.authority())
                .requestMatchers(POST, "/api/v1/page/**").hasAnyAuthority(PagePermission.CREATE.authority())
                .requestMatchers(PUT, "/api/v1/page/**").hasAnyAuthority(PagePermission.EDIT.authority())
                .requestMatchers(DELETE, "/api/v1/page/**").hasAnyAuthority(PagePermission.DELETE.authority())
                .requestMatchers("/api/v1/page/**").hasAnyRole(RoleEnum.COSTUMER.name(), RoleEnum.ADMIN.name())
        );
    }

    private static void defaultAuthorizeHttpRequests() throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/api/login").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated());
    }
}
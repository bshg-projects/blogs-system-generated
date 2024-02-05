package org.bshg.blogssystem;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.imagefile.facade.CreateImageFileProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.page.facade.CreatePageProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.zsecurity.bean.Role;
import org.bshg.blogssystem.zsecurity.bean.User;
import org.bshg.blogssystem.zsecurity.permissions.RoleEnum;
import org.bshg.blogssystem.zsecurity.service.facade.RoleService;
import org.bshg.blogssystem.zsecurity.service.facade.UserService;
import org.bshg.blogssystem.zutils.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitLoader implements ApplicationRunner {
    @Value("${app.data-loader.load}")
    private boolean load;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (load) {
            Console.log("Data Loading...");
            generatePermission();
            generateAdminAccount();
            generateCostumerAccount();
            generateAdmin();
            generateCostumer();
            generatePost();
            generateComment();
            generateTag();
            generateCategory();
            generateImageFile();
            generateLikeDislike();
            generateNotification();
            generateUserProfile();
            generatePage();
            Console.log("Data Loaded!");
        }
    }

    private void generatePermission() {
        for (RoleEnum role : RoleEnum.values()) {
            var roleEntity = role.getRole();
            roleService.save(roleEntity);
        }
    }

    private void generateAdminAccount() {
        User user = new User("admin");
        user.setPassword("123");
        Role role = new Role();
        role.setName(RoleEnum.ADMIN.name());
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);
        userService.save(user);
        Console.log("One Account For ADMIN role is created: 'admin' :: '123'");
    }

    private void generateCostumerAccount() {
        User user = new User("costumer");
        user.setPassword("123");
        Role role = new Role();
        role.setName(RoleEnum.COSTUMER.name());
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);
        userService.save(user);
        Console.log("One Account For COSTUMER role is created: 'costumer' :: '123'");
    }

    private void generateAdmin() {
        for (int i = 0; i < 50; i++) {
            Admin ent = new Admin();
            ent.setFirstname("firstname " + i);
            ent.setLastname("lastname " + i);
            ent.setPhoneNumber("phoneNumber " + i);
            ent.setUsername("client");
            ent.setPassword(userService.cryptPassword("client123"));
            List<Role> savedRoles = roleService.save(List.of(RoleEnum.CLIENT.getRole()));
            ent.setRoles(savedRoles);
            createAdminProcess.run(ent);
        }
        Console.log("Data For Admin Generated!");
    }

    private void generateCostumer() {
        for (int i = 0; i < 50; i++) {
            Costumer ent = new Costumer();
            ent.setFirstname("firstname " + i);
            ent.setLastname("lastname " + i);
            ent.setPhoneNumber("phoneNumber " + i);
            ent.setUsername("client");
            ent.setPassword(userService.cryptPassword("client123"));
            List<Role> savedRoles = roleService.save(List.of(RoleEnum.CLIENT.getRole()));
            ent.setRoles(savedRoles);
            createCostumerProcess.run(ent);
        }
        Console.log("Data For Costumer Generated!");
    }

    private void generatePost() {
        for (int i = 0; i < 50; i++) {
            Post ent = new Post();
            ent.setTitle("title " + i);
            ent.setContent("content " + i);
            createPostProcess.run(ent);
        }
        Console.log("Data For Post Generated!");
    }

    private void generateComment() {
        for (int i = 0; i < 50; i++) {
            Comment ent = new Comment();
            ent.setText("text " + i);
            createCommentProcess.run(ent);
        }
        Console.log("Data For Comment Generated!");
    }

    private void generateTag() {
        for (int i = 0; i < 50; i++) {
            Tag ent = new Tag();
            ent.setName("name " + i);
            createTagProcess.run(ent);
        }
        Console.log("Data For Tag Generated!");
    }

    private void generateCategory() {
        for (int i = 0; i < 50; i++) {
            Category ent = new Category();
            ent.setName("name " + i);
            createCategoryProcess.run(ent);
        }
        Console.log("Data For Category Generated!");
    }

    private void generateImageFile() {
        for (int i = 0; i < 50; i++) {
            ImageFile ent = new ImageFile();
            ent.setFilename("filename " + i);
            ent.setContentType("contentType " + i);
            ent.setLink("link " + i);
            createImageFileProcess.run(ent);
        }
        Console.log("Data For ImageFile Generated!");
    }

    private void generateLikeDislike() {
        for (int i = 0; i < 50; i++) {
            LikeDislike ent = new LikeDislike();
            createLikeDislikeProcess.run(ent);
        }
        Console.log("Data For LikeDislike Generated!");
    }

    private void generateNotification() {
        for (int i = 0; i < 50; i++) {
            Notification ent = new Notification();
            ent.setMessage("message " + i);
            createNotificationProcess.run(ent);
        }
        Console.log("Data For Notification Generated!");
    }

    private void generateUserProfile() {
        for (int i = 0; i < 50; i++) {
            UserProfile ent = new UserProfile();
            ent.setBio("bio " + i);
            ent.setProfilePicture("profilePicture " + i);
            createUserProfileProcess.run(ent);
        }
        Console.log("Data For UserProfile Generated!");
    }

    private void generatePage() {
        for (int i = 0; i < 50; i++) {
            Page ent = new Page();
            ent.setTitle("title " + i);
            ent.setContent("content " + i);
            createPageProcess.run(ent);
        }
        Console.log("Data For Page Generated!");
    }

    @Autowired
    private CreateAdminProcess createAdminProcess;
    @Autowired
    private CreateCostumerProcess createCostumerProcess;
    @Autowired
    private CreatePostProcess createPostProcess;
    @Autowired
    private CreateCommentProcess createCommentProcess;
    @Autowired
    private CreateTagProcess createTagProcess;
    @Autowired
    private CreateCategoryProcess createCategoryProcess;
    @Autowired
    private CreateImageFileProcess createImageFileProcess;
    @Autowired
    private CreateLikeDislikeProcess createLikeDislikeProcess;
    @Autowired
    private CreateNotificationProcess createNotificationProcess;
    @Autowired
    private CreateUserProfileProcess createUserProfileProcess;
    @Autowired
    private CreatePageProcess createPageProcess;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
}
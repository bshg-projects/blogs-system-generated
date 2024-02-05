package org.bshg.blogssystem.sprocess.userprofile;

import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.UpdateUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.impl.CreateUserProfileProcessImpl;
import org.bshg.blogssystem.sprocess.userprofile.impl.DeleteUserProfileProcessImpl;
import org.bshg.blogssystem.sprocess.userprofile.impl.UpdateUserProfileProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject UserProfile Processes (Create, Update, Delete).
 */
@Configuration
public class UserProfileInjector {
    @Bean
    public CreateUserProfileProcess createUserProfileProcess(UserProfileService service) {
        var bean = new CreateUserProfileProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdateUserProfileProcess updateUserProfileProcess(UserProfileService service) {
        var bean = new UpdateUserProfileProcessImpl(service);
        return bean;
    }

    @Bean
    public DeleteUserProfileProcess deleteUserProfileProcess(UserProfileService service) {
        var bean = new DeleteUserProfileProcessImpl(service);
        return bean;
    }
}
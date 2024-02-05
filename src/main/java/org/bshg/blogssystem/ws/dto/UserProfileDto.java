package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfileDto extends AuditBaseDto {
    public UserProfileDto() {
        super();
    }

    private String bio;
    private String profilePicture;

    public String getBio() {
        return bio;
    }

    public void setBio(String value) {
        this.bio = value;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String value) {
        this.profilePicture = value;
    }
}
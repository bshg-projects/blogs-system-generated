package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

@Entity
@Table(name = "user_profiles")
@SequenceGenerator(name = "user_profiles_seq", sequenceName = "user_profiles_seq", allocationSize = 1)
public class UserProfile extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profiles_seq")
    private Long id;
    private String bio;
    private String profilePicture;

    public UserProfile() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
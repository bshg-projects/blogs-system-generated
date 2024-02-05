package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.ws.dto.UserProfileDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter extends AbstractConverter<UserProfile, UserProfileDto> {
    @Override
    protected void config() {
        config(UserProfile.class, UserProfileDto.class);
    }

    @Override
    protected UserProfile convertToItem(UserProfileDto dto) {
        var item = new UserProfile();
        item.setId(dto.getId());
        item.setBio(dto.getBio());
        item.setProfilePicture(dto.getProfilePicture());
        return item;
    }

    @Override
    protected UserProfileDto convertToDto(UserProfile item) {
        var dto = new UserProfileDto();
        dto.setId(item.getId());
        dto.setBio(item.getBio());
        dto.setProfilePicture(item.getProfilePicture());
        return dto;
    }
}
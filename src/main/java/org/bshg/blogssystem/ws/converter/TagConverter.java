package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.ws.dto.TagDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagConverter extends AbstractConverter<Tag, TagDto> {
    @Autowired
    private PostConverter postConverter;
    private boolean post = true;

    @Override
    protected void config() {
        config(Tag.class, TagDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.postConverter.setTags(value);
    }

    @Override
    protected Tag convertToItem(TagDto dto) {
        var item = new Tag();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setPost(postConverter.toItem(dto.getPost()));
        return item;
    }

    @Override
    protected TagDto convertToDto(Tag item) {
        var dto = new TagDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPost(post ? postConverter.toDto(item.getPost()) : null);
        return dto;
    }

    public void setPost(boolean value) {
        this.post = value;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }
}
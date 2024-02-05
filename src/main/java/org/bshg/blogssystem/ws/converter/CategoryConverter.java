package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.ws.dto.CategoryDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDto> {
    @Autowired
    private PostConverter postConverter;
    private boolean posts = true;

    @Override
    protected void config() {
        config(Category.class, CategoryDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.postConverter.setCategory(value);
    }

    @Override
    protected Category convertToItem(CategoryDto dto) {
        var item = new Category();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setPosts(postConverter.toItem(dto.getPosts()));
        return item;
    }

    @Override
    protected CategoryDto convertToDto(Category item) {
        var dto = new CategoryDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPosts(posts ? postConverter.toDto(item.getPosts()) : null);
        return dto;
    }

    public void setPosts(boolean value) {
        this.posts = value;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }
}
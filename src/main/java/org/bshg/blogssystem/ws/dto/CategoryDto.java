package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends AuditBaseDto {
    public CategoryDto() {
        super();
    }

    private String name;
    private List<PostDto> posts;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> value) {
        this.posts = value;
    }
}
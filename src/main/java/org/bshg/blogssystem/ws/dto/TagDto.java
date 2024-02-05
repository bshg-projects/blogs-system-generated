package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto extends AuditBaseDto {
    public TagDto() {
        super();
    }

    private String name;
    private PostDto post;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto value) {
        this.post = value;
    }
}
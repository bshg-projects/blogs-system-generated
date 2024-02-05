package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageDto extends AuditBaseDto {
    public PageDto() {
        super();
    }

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }
}
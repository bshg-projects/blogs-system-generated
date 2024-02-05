package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageFileDto extends AuditBaseDto {
    public ImageFileDto() {
        super();
    }

    private String filename;
    private String contentType;
    private String link;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String value) {
        this.filename = value;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String value) {
        this.contentType = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String value) {
        this.link = value;
    }
}
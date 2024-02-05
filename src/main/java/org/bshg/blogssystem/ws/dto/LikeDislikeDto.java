package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.bean.enums.LikeDislikeTypeEnum;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeDislikeDto extends AuditBaseDto {
    public LikeDislikeDto() {
        super();
    }

    private LikeDislikeTypeEnum type;
    private AdminDto admin;
    private CostumerDto costumer;
    private PostDto post;
    private CommentDto comment;

    public LikeDislikeTypeEnum getType() {
        return type;
    }

    public void setType(LikeDislikeTypeEnum value) {
        this.type = value;
    }

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto value) {
        this.admin = value;
    }

    public CostumerDto getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerDto value) {
        this.costumer = value;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto value) {
        this.post = value;
    }

    public CommentDto getComment() {
        return comment;
    }

    public void setComment(CommentDto value) {
        this.comment = value;
    }
}
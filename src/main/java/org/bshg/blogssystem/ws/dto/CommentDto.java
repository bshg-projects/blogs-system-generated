package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto extends AuditBaseDto {
    public CommentDto() {
        super();
    }

    private String text;
    private LocalDateTime createdDate;
    private List<LikeDislikeDto> likesDislikes;
    private AdminDto admin;
    private CostumerDto costumer;
    private PostDto post;

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime value) {
        this.createdDate = value;
    }

    public List<LikeDislikeDto> getLikesDislikes() {
        return likesDislikes;
    }

    public void setLikesDislikes(List<LikeDislikeDto> value) {
        this.likesDislikes = value;
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
}
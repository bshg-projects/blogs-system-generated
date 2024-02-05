package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto extends AuditBaseDto {
    public PostDto() {
        super();
    }

    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private List<TagDto> tags;
    private List<CommentDto> comments;
    private List<LikeDislikeDto> likesDislikes;
    private AdminDto admin;
    private CostumerDto costumer;
    private CategoryDto category;

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime value) {
        this.createdDate = value;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime value) {
        this.lastModifiedDate = value;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> value) {
        this.tags = value;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> value) {
        this.comments = value;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto value) {
        this.category = value;
    }
}
package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.ws.dto.PostDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter extends AbstractConverter<Post, PostDto> {
    @Autowired
    private CategoryConverter categoryConverter;
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private CommentConverter commentConverter;
    @Autowired
    private LikeDislikeConverter likeDislikeConverter;
    @Autowired
    private TagConverter tagConverter;
    @Autowired
    private CostumerConverter costumerConverter;
    private boolean tags = true;
    private boolean comments = true;
    private boolean likesDislikes = true;
    private boolean admin = true;
    private boolean costumer = true;
    private boolean category = true;

    @Override
    protected void config() {
        config(Post.class, PostDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.categoryConverter.setPosts(value);
        this.adminConverter.setPosts(value);
        this.commentConverter.setPost(value);
        this.likeDislikeConverter.setPost(value);
        this.tagConverter.setPost(value);
        this.costumerConverter.setPosts(value);
    }

    @Override
    protected Post convertToItem(PostDto dto) {
        var item = new Post();
        item.setId(dto.getId());
        item.setTitle(dto.getTitle());
        item.setContent(dto.getContent());
        item.setCreatedDate(dto.getCreatedDate());
        item.setLastModifiedDate(dto.getLastModifiedDate());
        item.setTags(tagConverter.toItem(dto.getTags()));
        item.setComments(commentConverter.toItem(dto.getComments()));
        item.setLikesDislikes(likeDislikeConverter.toItem(dto.getLikesDislikes()));
        item.setAdmin(adminConverter.toItem(dto.getAdmin()));
        item.setCostumer(costumerConverter.toItem(dto.getCostumer()));
        item.setCategory(categoryConverter.toItem(dto.getCategory()));
        return item;
    }

    @Override
    protected PostDto convertToDto(Post item) {
        var dto = new PostDto();
        dto.setId(item.getId());
        dto.setTitle(item.getTitle());
        dto.setContent(item.getContent());
        dto.setCreatedDate(item.getCreatedDate());
        dto.setLastModifiedDate(item.getLastModifiedDate());
        dto.setTags(tags ? tagConverter.toDto(item.getTags()) : null);
        dto.setComments(comments ? commentConverter.toDto(item.getComments()) : null);
        dto.setLikesDislikes(likesDislikes ? likeDislikeConverter.toDto(item.getLikesDislikes()) : null);
        dto.setAdmin(admin ? adminConverter.toDto(item.getAdmin()) : null);
        dto.setCostumer(costumer ? costumerConverter.toDto(item.getCostumer()) : null);
        dto.setCategory(category ? categoryConverter.toDto(item.getCategory()) : null);
        return dto;
    }

    public void setTags(boolean value) {
        this.tags = value;
    }

    public void setComments(boolean value) {
        this.comments = value;
    }

    public void setLikesDislikes(boolean value) {
        this.likesDislikes = value;
    }

    public void setAdmin(boolean value) {
        this.admin = value;
    }

    public void setCostumer(boolean value) {
        this.costumer = value;
    }

    public void setCategory(boolean value) {
        this.category = value;
    }

    public void setCategoryConverter(CategoryConverter value) {
        this.categoryConverter = value;
    }

    public CategoryConverter getCategoryConverter() {
        return categoryConverter;
    }

    public void setAdminConverter(AdminConverter value) {
        this.adminConverter = value;
    }

    public AdminConverter getAdminConverter() {
        return adminConverter;
    }

    public void setCommentConverter(CommentConverter value) {
        this.commentConverter = value;
    }

    public CommentConverter getCommentConverter() {
        return commentConverter;
    }

    public void setLikeDislikeConverter(LikeDislikeConverter value) {
        this.likeDislikeConverter = value;
    }

    public LikeDislikeConverter getLikeDislikeConverter() {
        return likeDislikeConverter;
    }

    public void setTagConverter(TagConverter value) {
        this.tagConverter = value;
    }

    public TagConverter getTagConverter() {
        return tagConverter;
    }

    public void setCostumerConverter(CostumerConverter value) {
        this.costumerConverter = value;
    }

    public CostumerConverter getCostumerConverter() {
        return costumerConverter;
    }
}
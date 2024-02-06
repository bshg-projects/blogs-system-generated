package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.ws.dto.CommentDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter extends AbstractConverter<Comment, CommentDto> {
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private LikeDislikeConverter likeDislikeConverter;
    @Autowired
    private CostumerConverter costumerConverter;
    @Autowired
    private AdminConverter adminConverter;
    private boolean likesDislikes = true;
    private boolean admin = true;
    private boolean costumer = true;
    private boolean post = true;

    @Override
    protected void config() {
        config(Comment.class, CommentDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.postConverter.setComments(value);
        this.likeDislikeConverter.setComment(value);
        this.costumerConverter.setComments(value);
        this.adminConverter.setComments(value);
    }

    @Override
    protected Comment convertToItem(CommentDto dto) {
        var item = new Comment();
        item.setId(dto.getId());
        item.setText(dto.getText());
        item.setCreatedDate(dto.getCreatedDate());
        item.setLikesDislikes(likeDislikeConverter.toItem(dto.getLikesDislikes()));
        item.setAdmin(adminConverter.toItem(dto.getAdmin()));
        item.setCostumer(costumerConverter.toItem(dto.getCostumer()));
        item.setPost(postConverter.toItem(dto.getPost()));
        return item;
    }

    @Override
    protected CommentDto convertToDto(Comment item) {
        var dto = new CommentDto();
        dto.setId(item.getId());
        dto.setText(item.getText());
        dto.setCreatedDate(item.getCreatedDate());
        dto.setLikesDislikes(likesDislikes ? likeDislikeConverter.toDto(item.getLikesDislikes()) : null);
        dto.setAdmin(admin ? adminConverter.toDto(item.getAdmin()) : null);
        dto.setCostumer(costumer ? costumerConverter.toDto(item.getCostumer()) : null);
        dto.setPost(post ? postConverter.toDto(item.getPost()) : null);
        return dto;
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

    public void setPost(boolean value) {
        this.post = value;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }

    public void setLikeDislikeConverter(LikeDislikeConverter value) {
        this.likeDislikeConverter = value;
    }

    public LikeDislikeConverter getLikeDislikeConverter() {
        return likeDislikeConverter;
    }

    public void setCostumerConverter(CostumerConverter value) {
        this.costumerConverter = value;
    }

    public CostumerConverter getCostumerConverter() {
        return costumerConverter;
    }

    public void setAdminConverter(AdminConverter value) {
        this.adminConverter = value;
    }

    public AdminConverter getAdminConverter() {
        return adminConverter;
    }
}
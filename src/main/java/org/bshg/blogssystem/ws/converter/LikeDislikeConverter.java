package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.ws.dto.LikeDislikeDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikeDislikeConverter extends AbstractConverter<LikeDislike, LikeDislikeDto> {
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private CostumerConverter costumerConverter;
    @Autowired
    private CommentConverter commentConverter;
    @Autowired
    private AdminConverter adminConverter;
    private boolean admin = true;
    private boolean costumer = true;
    private boolean post = true;
    private boolean comment = true;

    @Override
    protected void config() {
        config(LikeDislike.class, LikeDislikeDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.postConverter.setLikesDislikes(value);
        this.costumerConverter.setLikeDislikes(value);
        this.commentConverter.setLikesDislikes(value);
        this.adminConverter.setLikeDislikes(value);
    }

    @Override
    protected LikeDislike convertToItem(LikeDislikeDto dto) {
        var item = new LikeDislike();
        item.setId(dto.getId());
        item.setType(dto.getType());
        item.setAdmin(adminConverter.toItem(dto.getAdmin()));
        item.setCostumer(costumerConverter.toItem(dto.getCostumer()));
        item.setPost(postConverter.toItem(dto.getPost()));
        item.setComment(commentConverter.toItem(dto.getComment()));
        return item;
    }

    @Override
    protected LikeDislikeDto convertToDto(LikeDislike item) {
        var dto = new LikeDislikeDto();
        dto.setId(item.getId());
        dto.setType(item.getType());
        dto.setAdmin(admin ? adminConverter.toDto(item.getAdmin()) : null);
        dto.setCostumer(costumer ? costumerConverter.toDto(item.getCostumer()) : null);
        dto.setPost(post ? postConverter.toDto(item.getPost()) : null);
        dto.setComment(comment ? commentConverter.toDto(item.getComment()) : null);
        return dto;
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

    public void setComment(boolean value) {
        this.comment = value;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }

    public void setCostumerConverter(CostumerConverter value) {
        this.costumerConverter = value;
    }

    public CostumerConverter getCostumerConverter() {
        return costumerConverter;
    }

    public void setCommentConverter(CommentConverter value) {
        this.commentConverter = value;
    }

    public CommentConverter getCommentConverter() {
        return commentConverter;
    }

    public void setAdminConverter(AdminConverter value) {
        this.adminConverter = value;
    }

    public AdminConverter getAdminConverter() {
        return adminConverter;
    }
}
package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.ws.dto.ImageFileDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class ImageFileConverter extends AbstractConverter<ImageFile, ImageFileDto> {
    @Override
    protected void config() {
        config(ImageFile.class, ImageFileDto.class);
    }

    @Override
    protected ImageFile convertToItem(ImageFileDto dto) {
        var item = new ImageFile();
        item.setId(dto.getId());
        item.setFilename(dto.getFilename());
        item.setContentType(dto.getContentType());
        item.setLink(dto.getLink());
        return item;
    }

    @Override
    protected ImageFileDto convertToDto(ImageFile item) {
        var dto = new ImageFileDto();
        dto.setId(item.getId());
        dto.setFilename(item.getFilename());
        dto.setContentType(item.getContentType());
        dto.setLink(item.getLink());
        return dto;
    }
}
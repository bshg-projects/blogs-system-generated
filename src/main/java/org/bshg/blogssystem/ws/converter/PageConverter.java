package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.ws.dto.PageDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class PageConverter extends AbstractConverter<Page, PageDto> {
    @Override
    protected void config() {
        config(Page.class, PageDto.class);
    }

    @Override
    protected Page convertToItem(PageDto dto) {
        var item = new Page();
        item.setId(dto.getId());
        item.setTitle(dto.getTitle());
        item.setContent(dto.getContent());
        return item;
    }

    @Override
    protected PageDto convertToDto(Page item) {
        var dto = new PageDto();
        dto.setId(item.getId());
        dto.setTitle(item.getTitle());
        dto.setContent(item.getContent());
        return dto;
    }
}
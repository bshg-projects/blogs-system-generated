package org.bshg.blogssystem.zutils.webservice.converter;

import org.bshg.blogssystem.zutils.bean.BusinessObject;
import org.bshg.blogssystem.zutils.webservice.dto.BaseDto;

import java.util.List;

import static org.bshg.blogssystem.zutils.util.ListUtil.map;

public abstract class AbstractConverter<T extends BusinessObject, DTO extends BaseDto> {
    protected Class<T> itemType;
    protected Class<DTO> dtoType;

    protected AbstractConverter() {
        this.config();
    }

    protected final void config(Class<T> itemType, Class<DTO> dtoType) {
        this.itemType = itemType;
        this.dtoType = dtoType;
        this.init(true);
    }

    protected abstract DTO convertToDto(T t);

    protected abstract T convertToItem(DTO d);

    protected abstract void config();

    protected void convertersConfig(boolean value) {
    }

    public final DTO toDto(T t) {
        this.convertersConfig(false);
        var dto = t != null ? convertToDto(t) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final T toItem(DTO d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<T> toItem(List<DTO> dtos) {
        return map(dtos, this::toItem);
    }

    public final List<DTO> toDto(List<T> items) {
        return map(items, this::toDto);
    }

    public void init(boolean initialisation) {
        initObject(initialisation);
        initList(initialisation);
    }

    public void initObject(boolean initialisationObject) {
    }

    public void initList(boolean initialisationList) {
    }

}

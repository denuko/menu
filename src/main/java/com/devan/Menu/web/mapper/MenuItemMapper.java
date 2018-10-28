package com.devan.Menu.web.mapper;

import com.devan.Menu.dao.model.MenuItem;
import com.devan.Menu.web.dto.MenuItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuItemMapper extends MyMapper<MenuItem, MenuItemDto>{
}

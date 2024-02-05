package org.bshg.blogssystem.zsecurity.ws.restapi;

import org.bshg.blogssystem.zsecurity.service.facade.RoleService;
import org.bshg.blogssystem.zsecurity.ws.converter.RoleConverter;
import org.bshg.blogssystem.zsecurity.ws.dto.RoleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/roles")
public class RoleRest {
    private final RoleService roleService;
    private final RoleConverter roleConverter;

    public RoleRest(RoleService roleService, RoleConverter roleConverter) {
        this.roleService = roleService;
        this.roleConverter = roleConverter;
    }

    @GetMapping("/")
    public List<RoleDto> findAll() {
        return roleConverter.toDto(this.roleService.findAll());
    }
}

package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.ws.converter.AdminConverter;
import org.bshg.blogssystem.ws.dto.AdminDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestApi extends AbstractRestApi<
        Admin,
        AdminDto,
        AdminService,
        AdminConverter,
        CreateAdminProcess,
        UpdateAdminProcess,
        DeleteAdminProcess> {
    public AdminRestApi(AdminService service, AdminConverter converter, CreateAdminProcess createProcess, UpdateAdminProcess updateProcess, DeleteAdminProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<AdminDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AdminDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<AdminDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<AdminDto> save(@RequestBody AdminDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<AdminDto>> save(@RequestBody List<AdminDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<AdminDto>> update(@RequestBody List<AdminDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<AdminDto> delete(@RequestBody AdminDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<AdminDto>> delete(@RequestBody List<AdminDto> dtos) {
        return super.delete(dtos);
    }

    @Override
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }

    @Override
    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) {
        return super.deleteByIdIn(ids);
    }

    @Override
    @DeleteMapping("/with-lists")
    public ResponseEntity<AdminDto> deleteWithAssociatedLists(@RequestBody AdminDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<AdminDto>> deleteWithAssociatedLists(@RequestBody List<AdminDto> dtos) {
        return super.deleteWithAssociatedLists(dtos);
    }

    @Override
    @DeleteMapping("/id/{id}/with-lists")
    public ResponseEntity<Long> deleteByIdWithAssociatedLists(@PathVariable Long id) {
        return super.deleteByIdWithAssociatedLists(id);
    }

    @Override
    @DeleteMapping("/ids/with-lists")
    public ResponseEntity<List<Long>> deleteByIdInWithAssociatedLists(@RequestBody List<Long> ids) {
        return super.deleteByIdInWithAssociatedLists(ids);
    }

    @DeleteMapping("/profile/id/{id}")
    public ResponseEntity<Long> deleteByProfileId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByProfileId);
    }

    @GetMapping("/profile/id/{id}")
    public ResponseEntity<AdminDto> findByProfileId(@PathVariable Long id) {
        return super.findByChildId(id, service::findByProfileId);
    }
}
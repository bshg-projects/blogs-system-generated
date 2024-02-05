package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.UpdateUserProfileProcess;
import org.bshg.blogssystem.ws.converter.UserProfileConverter;
import org.bshg.blogssystem.ws.dto.UserProfileDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userprofile")
public class UserProfileRestApi extends AbstractRestApi<
        UserProfile,
        UserProfileDto,
        UserProfileService,
        UserProfileConverter,
        CreateUserProfileProcess,
        UpdateUserProfileProcess,
        DeleteUserProfileProcess> {
    public UserProfileRestApi(UserProfileService service, UserProfileConverter converter, CreateUserProfileProcess createProcess, UpdateUserProfileProcess updateProcess, DeleteUserProfileProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserProfileDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserProfileDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<UserProfileDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<UserProfileDto> save(@RequestBody UserProfileDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<UserProfileDto>> save(@RequestBody List<UserProfileDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<UserProfileDto> update(@RequestBody UserProfileDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<UserProfileDto>> update(@RequestBody List<UserProfileDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<UserProfileDto> delete(@RequestBody UserProfileDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<UserProfileDto>> delete(@RequestBody List<UserProfileDto> dtos) {
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
    public ResponseEntity<UserProfileDto> deleteWithAssociatedLists(@RequestBody UserProfileDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<UserProfileDto>> deleteWithAssociatedLists(@RequestBody List<UserProfileDto> dtos) {
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
}
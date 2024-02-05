package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.UpdateNotificationProcess;
import org.bshg.blogssystem.ws.converter.NotificationConverter;
import org.bshg.blogssystem.ws.dto.NotificationDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRestApi extends AbstractRestApi<
        Notification,
        NotificationDto,
        NotificationService,
        NotificationConverter,
        CreateNotificationProcess,
        UpdateNotificationProcess,
        DeleteNotificationProcess> {
    public NotificationRestApi(NotificationService service, NotificationConverter converter, CreateNotificationProcess createProcess, UpdateNotificationProcess updateProcess, DeleteNotificationProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<NotificationDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<NotificationDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<NotificationDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<NotificationDto> save(@RequestBody NotificationDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<NotificationDto>> save(@RequestBody List<NotificationDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<NotificationDto> update(@RequestBody NotificationDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<NotificationDto>> update(@RequestBody List<NotificationDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<NotificationDto> delete(@RequestBody NotificationDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<NotificationDto>> delete(@RequestBody List<NotificationDto> dtos) {
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
    public ResponseEntity<NotificationDto> deleteWithAssociatedLists(@RequestBody NotificationDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<NotificationDto>> deleteWithAssociatedLists(@RequestBody List<NotificationDto> dtos) {
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

    @DeleteMapping("/admin/id/{id}")
    public ResponseEntity<Long> deleteByAdminId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByAdminId);
    }

    @GetMapping("/admin/id/{id}")
    public ResponseEntity<List<NotificationDto>> findByAdminId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByAdminId);
    }

    @DeleteMapping("/costumer/id/{id}")
    public ResponseEntity<Long> deleteByCostumerId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCostumerId);
    }

    @GetMapping("/costumer/id/{id}")
    public ResponseEntity<List<NotificationDto>> findByCostumerId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCostumerId);
    }
}
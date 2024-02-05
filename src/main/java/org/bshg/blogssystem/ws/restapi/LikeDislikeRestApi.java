package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.service.facade.LikeDislikeService;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.ws.converter.LikeDislikeConverter;
import org.bshg.blogssystem.ws.dto.LikeDislikeDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/likedislike")
public class LikeDislikeRestApi extends AbstractRestApi<
        LikeDislike,
        LikeDislikeDto,
        LikeDislikeService,
        LikeDislikeConverter,
        CreateLikeDislikeProcess,
        UpdateLikeDislikeProcess,
        DeleteLikeDislikeProcess> {
    public LikeDislikeRestApi(LikeDislikeService service, LikeDislikeConverter converter, CreateLikeDislikeProcess createProcess, UpdateLikeDislikeProcess updateProcess, DeleteLikeDislikeProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<LikeDislikeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LikeDislikeDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<LikeDislikeDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<LikeDislikeDto> save(@RequestBody LikeDislikeDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<LikeDislikeDto>> save(@RequestBody List<LikeDislikeDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<LikeDislikeDto> update(@RequestBody LikeDislikeDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<LikeDislikeDto>> update(@RequestBody List<LikeDislikeDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<LikeDislikeDto> delete(@RequestBody LikeDislikeDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<LikeDislikeDto>> delete(@RequestBody List<LikeDislikeDto> dtos) {
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
    public ResponseEntity<LikeDislikeDto> deleteWithAssociatedLists(@RequestBody LikeDislikeDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<LikeDislikeDto>> deleteWithAssociatedLists(@RequestBody List<LikeDislikeDto> dtos) {
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
    public ResponseEntity<List<LikeDislikeDto>> findByAdminId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByAdminId);
    }

    @DeleteMapping("/costumer/id/{id}")
    public ResponseEntity<Long> deleteByCostumerId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCostumerId);
    }

    @GetMapping("/costumer/id/{id}")
    public ResponseEntity<List<LikeDislikeDto>> findByCostumerId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCostumerId);
    }

    @DeleteMapping("/post/id/{id}")
    public ResponseEntity<Long> deleteByPostId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByPostId);
    }

    @GetMapping("/post/id/{id}")
    public ResponseEntity<List<LikeDislikeDto>> findByPostId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByPostId);
    }

    @DeleteMapping("/comment/id/{id}")
    public ResponseEntity<Long> deleteByCommentId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCommentId);
    }

    @GetMapping("/comment/id/{id}")
    public ResponseEntity<List<LikeDislikeDto>> findByCommentId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCommentId);
    }
}
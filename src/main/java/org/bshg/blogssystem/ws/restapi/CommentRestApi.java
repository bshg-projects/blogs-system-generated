package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.service.facade.CommentService;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.ws.converter.CommentConverter;
import org.bshg.blogssystem.ws.dto.CommentDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentRestApi extends AbstractRestApi<
        Comment,
        CommentDto,
        CommentService,
        CommentConverter,
        CreateCommentProcess,
        UpdateCommentProcess,
        DeleteCommentProcess> {
    public CommentRestApi(CommentService service, CommentConverter converter, CreateCommentProcess createProcess, UpdateCommentProcess updateProcess, DeleteCommentProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<CommentDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<CommentDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<CommentDto>> save(@RequestBody List<CommentDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<CommentDto> update(@RequestBody CommentDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<CommentDto>> update(@RequestBody List<CommentDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<CommentDto> delete(@RequestBody CommentDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<CommentDto>> delete(@RequestBody List<CommentDto> dtos) {
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
    public ResponseEntity<CommentDto> deleteWithAssociatedLists(@RequestBody CommentDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<CommentDto>> deleteWithAssociatedLists(@RequestBody List<CommentDto> dtos) {
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
    public ResponseEntity<List<CommentDto>> findByAdminId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByAdminId);
    }

    @DeleteMapping("/costumer/id/{id}")
    public ResponseEntity<Long> deleteByCostumerId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCostumerId);
    }

    @GetMapping("/costumer/id/{id}")
    public ResponseEntity<List<CommentDto>> findByCostumerId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCostumerId);
    }

    @DeleteMapping("/post/id/{id}")
    public ResponseEntity<Long> deleteByPostId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByPostId);
    }

    @GetMapping("/post/id/{id}")
    public ResponseEntity<List<CommentDto>> findByPostId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByPostId);
    }
}
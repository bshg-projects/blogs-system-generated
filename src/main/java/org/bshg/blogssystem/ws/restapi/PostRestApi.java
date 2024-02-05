package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.ws.converter.PostConverter;
import org.bshg.blogssystem.ws.dto.PostDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostRestApi extends AbstractRestApi<
        Post,
        PostDto,
        PostService,
        PostConverter,
        CreatePostProcess,
        UpdatePostProcess,
        DeletePostProcess> {
    public PostRestApi(PostService service, PostConverter converter, CreatePostProcess createProcess, UpdatePostProcess updateProcess, DeletePostProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<PostDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<PostDto> save(@RequestBody PostDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<PostDto>> save(@RequestBody List<PostDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<PostDto> update(@RequestBody PostDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<PostDto>> update(@RequestBody List<PostDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<PostDto> delete(@RequestBody PostDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<PostDto>> delete(@RequestBody List<PostDto> dtos) {
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
    public ResponseEntity<PostDto> deleteWithAssociatedLists(@RequestBody PostDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<PostDto>> deleteWithAssociatedLists(@RequestBody List<PostDto> dtos) {
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
    public ResponseEntity<List<PostDto>> findByAdminId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByAdminId);
    }

    @DeleteMapping("/costumer/id/{id}")
    public ResponseEntity<Long> deleteByCostumerId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCostumerId);
    }

    @GetMapping("/costumer/id/{id}")
    public ResponseEntity<List<PostDto>> findByCostumerId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCostumerId);
    }

    @DeleteMapping("/category/id/{id}")
    public ResponseEntity<Long> deleteByCategoryId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByCategoryId);
    }

    @GetMapping("/category/id/{id}")
    public ResponseEntity<List<PostDto>> findByCategoryId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByCategoryId);
    }
}
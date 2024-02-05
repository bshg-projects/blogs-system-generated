package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.UpdateTagProcess;
import org.bshg.blogssystem.ws.converter.TagConverter;
import org.bshg.blogssystem.ws.dto.TagDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagRestApi extends AbstractRestApi<
        Tag,
        TagDto,
        TagService,
        TagConverter,
        CreateTagProcess,
        UpdateTagProcess,
        DeleteTagProcess> {
    public TagRestApi(TagService service, TagConverter converter, CreateTagProcess createProcess, UpdateTagProcess updateProcess, DeleteTagProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<TagDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TagDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<TagDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<TagDto> save(@RequestBody TagDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<TagDto>> save(@RequestBody List<TagDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<TagDto> update(@RequestBody TagDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<TagDto>> update(@RequestBody List<TagDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<TagDto> delete(@RequestBody TagDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<TagDto>> delete(@RequestBody List<TagDto> dtos) {
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
    public ResponseEntity<TagDto> deleteWithAssociatedLists(@RequestBody TagDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<TagDto>> deleteWithAssociatedLists(@RequestBody List<TagDto> dtos) {
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

    @DeleteMapping("/post/id/{id}")
    public ResponseEntity<Long> deleteByPostId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByPostId);
    }

    @GetMapping("/post/id/{id}")
    public ResponseEntity<List<TagDto>> findByPostId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByPostId);
    }
}
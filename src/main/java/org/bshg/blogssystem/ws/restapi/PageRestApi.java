package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.sprocess.page.facade.CreatePageProcess;
import org.bshg.blogssystem.sprocess.page.facade.DeletePageProcess;
import org.bshg.blogssystem.sprocess.page.facade.UpdatePageProcess;
import org.bshg.blogssystem.ws.converter.PageConverter;
import org.bshg.blogssystem.ws.dto.PageDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/page")
public class PageRestApi extends AbstractRestApi<
        Page,
        PageDto,
        PageService,
        PageConverter,
        CreatePageProcess,
        UpdatePageProcess,
        DeletePageProcess> {
    public PageRestApi(PageService service, PageConverter converter, CreatePageProcess createProcess, UpdatePageProcess updateProcess, DeletePageProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<PageDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PageDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<PageDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<PageDto> save(@RequestBody PageDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<PageDto>> save(@RequestBody List<PageDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<PageDto> update(@RequestBody PageDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<PageDto>> update(@RequestBody List<PageDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<PageDto> delete(@RequestBody PageDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<PageDto>> delete(@RequestBody List<PageDto> dtos) {
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
    public ResponseEntity<PageDto> deleteWithAssociatedLists(@RequestBody PageDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<PageDto>> deleteWithAssociatedLists(@RequestBody List<PageDto> dtos) {
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
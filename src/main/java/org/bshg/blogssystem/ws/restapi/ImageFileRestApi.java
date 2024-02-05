package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.sprocess.imagefile.facade.CreateImageFileProcess;
import org.bshg.blogssystem.sprocess.imagefile.facade.DeleteImageFileProcess;
import org.bshg.blogssystem.sprocess.imagefile.facade.UpdateImageFileProcess;
import org.bshg.blogssystem.ws.converter.ImageFileConverter;
import org.bshg.blogssystem.ws.dto.ImageFileDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imagefile")
public class ImageFileRestApi extends AbstractRestApi<
        ImageFile,
        ImageFileDto,
        ImageFileService,
        ImageFileConverter,
        CreateImageFileProcess,
        UpdateImageFileProcess,
        DeleteImageFileProcess> {
    public ImageFileRestApi(ImageFileService service, ImageFileConverter converter, CreateImageFileProcess createProcess, UpdateImageFileProcess updateProcess, DeleteImageFileProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<ImageFileDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ImageFileDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<ImageFileDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<ImageFileDto> save(@RequestBody ImageFileDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<ImageFileDto>> save(@RequestBody List<ImageFileDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<ImageFileDto> update(@RequestBody ImageFileDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<ImageFileDto>> update(@RequestBody List<ImageFileDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ImageFileDto> delete(@RequestBody ImageFileDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<ImageFileDto>> delete(@RequestBody List<ImageFileDto> dtos) {
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
    public ResponseEntity<ImageFileDto> deleteWithAssociatedLists(@RequestBody ImageFileDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<ImageFileDto>> deleteWithAssociatedLists(@RequestBody List<ImageFileDto> dtos) {
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
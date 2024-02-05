package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.UpdateCategoryProcess;
import org.bshg.blogssystem.ws.converter.CategoryConverter;
import org.bshg.blogssystem.ws.dto.CategoryDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestApi extends AbstractRestApi<
        Category,
        CategoryDto,
        CategoryService,
        CategoryConverter,
        CreateCategoryProcess,
        UpdateCategoryProcess,
        DeleteCategoryProcess> {
    public CategoryRestApi(CategoryService service, CategoryConverter converter, CreateCategoryProcess createProcess, UpdateCategoryProcess updateProcess, DeleteCategoryProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<CategoryDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<CategoryDto>> save(@RequestBody List<CategoryDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<CategoryDto>> update(@RequestBody List<CategoryDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<CategoryDto> delete(@RequestBody CategoryDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<CategoryDto>> delete(@RequestBody List<CategoryDto> dtos) {
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
    public ResponseEntity<CategoryDto> deleteWithAssociatedLists(@RequestBody CategoryDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<CategoryDto>> deleteWithAssociatedLists(@RequestBody List<CategoryDto> dtos) {
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
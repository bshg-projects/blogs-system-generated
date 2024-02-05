package org.bshg.blogssystem.ws.restapi;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.ws.converter.CostumerConverter;
import org.bshg.blogssystem.ws.dto.CostumerDto;
import org.bshg.blogssystem.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/costumer")
public class CostumerRestApi extends AbstractRestApi<
        Costumer,
        CostumerDto,
        CostumerService,
        CostumerConverter,
        CreateCostumerProcess,
        UpdateCostumerProcess,
        DeleteCostumerProcess> {
    public CostumerRestApi(CostumerService service, CostumerConverter converter, CreateCostumerProcess createProcess, UpdateCostumerProcess updateProcess, DeleteCostumerProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<CostumerDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CostumerDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<CostumerDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<CostumerDto> save(@RequestBody CostumerDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<CostumerDto>> save(@RequestBody List<CostumerDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<CostumerDto> update(@RequestBody CostumerDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<CostumerDto>> update(@RequestBody List<CostumerDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<CostumerDto> delete(@RequestBody CostumerDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<CostumerDto>> delete(@RequestBody List<CostumerDto> dtos) {
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
    public ResponseEntity<CostumerDto> deleteWithAssociatedLists(@RequestBody CostumerDto dto) {
        return super.deleteWithAssociatedLists(dto);
    }

    @Override
    @DeleteMapping("/all/with-lists")
    public ResponseEntity<List<CostumerDto>> deleteWithAssociatedLists(@RequestBody List<CostumerDto> dtos) {
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
    public ResponseEntity<CostumerDto> findByProfileId(@PathVariable Long id) {
        return super.findByChildId(id, service::findByProfileId);
    }
}
package org.bshg.blogssystem.zutils.webservice.restapi;

import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;
import org.bshg.blogssystem.zutils.service.IService;
import org.bshg.blogssystem.zutils.sprocess.facade.ICreateProcess;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;
import org.bshg.blogssystem.zutils.sprocess.facade.IUpdateProcess;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.bshg.blogssystem.zutils.webservice.dto.BaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongFunction;

public abstract class AbstractRestApi<
        T extends AuditBusinessObject, DTO extends BaseDto,
        SERV extends IService<T>, CONV extends AbstractConverter<T, DTO>,
        CP extends ICreateProcess<T>,
        UP extends IUpdateProcess<T>,
        DP extends IDeleteProcess<T>
        > extends RestApiHelper {

    protected SERV service;
    protected AbstractConverter<T, DTO> converter;
    protected CP createProcess;
    protected UP updateProcess;
    protected DP deleteProcess;

    protected AbstractRestApi(SERV service, CONV converter, CP createProcess, UP updateProcess, DP deleteProcess) {
        this.service = service;
        this.converter = converter;
        this.createProcess = createProcess;
        this.updateProcess = updateProcess;
        this.deleteProcess = deleteProcess;
    }

    protected ResponseEntity<DTO> findById(Long id) {
        T t = service.findById(id);
        return sendResponse(t == null, HttpStatus.NOT_FOUND, () -> {
            converter.init(true);
            DTO dto = converter.toDto(t);
            return success(dto);
        });
    }

    protected ResponseEntity<List<DTO>> findAll() {
        List<T> all = service.findAll();
        List<DTO> dtos = converter.toDto(all);
        return success(dtos);
    }

    protected ResponseEntity<List<DTO>> findAllOptimized() {
        List<T> list = service.findAllOptimized();
        List<DTO> dtos = converter.toDto(list);
        return sendResponses(dtos != null && !dtos.isEmpty(), () -> success(dtos));
    }

    protected ResponseEntity<DTO> save(DTO dto) {
        return sendResponse(dto == null, () -> {
            converter.init(true);
            T myT = converter.toItem(dto);
            T t = createProcess.run(myT);
            DTO myDto = converter.toDto(t);
            return new ResponseEntity<>(myDto, HttpStatus.CREATED);
        });
    }

    protected ResponseEntity<List<DTO>> save(List<DTO> dtos) {
        return sendResponse(dtos == null, () -> {
            converter.init(true);
            List<T> myT = converter.toItem(dtos);
            List<T> ts = createProcess.run(myT);
            List<DTO> myDto = converter.toDto(ts);
            return new ResponseEntity<>(myDto, HttpStatus.CREATED);
        });
    }

    protected ResponseEntity<DTO> update(DTO dtos) {
        return sendResponse((dtos == null), () -> {
            T ts = converter.toItem(dtos);
            T updated = updateProcess.run(ts);
            DTO myDtos = converter.toDto(updated);
            return success(myDtos);
        });
    }

    protected ResponseEntity<List<DTO>> update(List<DTO> dtos) {
        return sendResponse((dtos == null), () -> {
            List<T> ts = converter.toItem(dtos);
            List<T> updated = updateProcess.run(ts);
            List<DTO> myDtos = converter.toDto(updated);
            return success(myDtos);
        });
    }

    protected ResponseEntity<DTO> delete(DTO dto) {
        return sendResponse(dto == null, () -> {
            converter.init(false);
            T t = converter.toItem(dto);
            deleteProcess.run(t);
            return success(dto);
        });
    }

    protected ResponseEntity<List<DTO>> delete(List<DTO> dtos) {
        return sendResponses((dtos != null && !dtos.isEmpty()), () -> {
            converter.init(false);
            List<T> ts = converter.toItem(dtos);
            deleteProcess.run(ts);
            return success(dtos);
        });
    }

    protected ResponseEntity<Long> deleteById(Long id) {
        return sendResponse(id == null, () -> {
            deleteProcess.run(id);
            return success(id);
        });
    }

    protected ResponseEntity<List<Long>> deleteByIdIn(List<Long> ids) {
        return sendResponse(ids == null, () -> {
            deleteProcess.runByIds(ids);
            return success(ids);
        });
    }

    protected ResponseEntity<DTO> deleteWithAssociatedLists(DTO dto) {
        return sendResponse(dto == null, () -> {
            converter.init(false);
            T t = converter.toItem(dto);
            deleteProcess.deleteWithAssociatedList(t);
            return success(dto);
        });
    }

    protected ResponseEntity<List<DTO>> deleteWithAssociatedLists(List<DTO> dtos) {
        return sendResponses(dtos != null && !dtos.isEmpty(), () -> {
            converter.init(false);
            List<T> ts = converter.toItem(dtos);
            deleteProcess.deleteWithAssociatedList(ts);
            return success(dtos);
        });
    }

    protected ResponseEntity<Long> deleteByIdWithAssociatedLists(Long id) {
        return sendResponse(id == null, () -> {
            deleteProcess.deleteWithAssociatedList(id);
            return success(id);
        });
    }

    protected ResponseEntity<List<Long>> deleteByIdInWithAssociatedLists(List<Long> ids) {
        return sendResponse(ids == null, () -> {
            deleteProcess.deleteWithAssociatedListByIds(ids);
            return success(ids);
        });
    }

    public ResponseEntity<List<DTO>> findListByChildId(Long id, LongFunction<List<T>> getter) {
        List<T> ts = getter.apply(id);
        List<DTO> dtos = converter.toDto(ts);
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<DTO> findByChildId(Long id, LongFunction<T> getter) {
        T t = getter.apply(id);
        DTO dto = converter.toDto(t);
        return ResponseEntity.ok(dto);
    }

    protected <O> ResponseEntity<O> deleteProcess(O object, Consumer<O> process) {
        ResponseEntity<O> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (object != null) {
            process.accept(object);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(object, status);
        return res;
    }
}

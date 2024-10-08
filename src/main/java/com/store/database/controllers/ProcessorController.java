package com.store.database.controllers;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.Processor.ProcessorCreateDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.Processor.ProcessorUpdateDto;
import com.store.database.interfaces.CRUDControllerOperations;
import com.store.database.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cpu")
public class ProcessorController implements CRUDControllerOperations<ProcessorDto, ProcessorCreateDto, ProcessorUpdateDto> {

    private final ProcessorService cpuService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessorDto> index(
            ParamsDto param,
            @RequestParam(required = false) Double percentage) {

        if (percentage != null) {
            cpuService.increasePrices(percentage);
        }
        return (param != null) ? cpuService.sort(param) : cpuService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProcessorDto getById(@PathVariable Long id) {
        return cpuService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProcessorCreateDto dto) {
        cpuService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cpuService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ProcessorUpdateDto dto, @PathVariable Long id) {
        cpuService.update(dto, id);
    }

}

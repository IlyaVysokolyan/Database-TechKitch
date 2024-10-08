package com.store.database.controllers;

import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.Cooler.CreateCoolerDto;
import com.store.database.DTO.Cooler.UpdateCoolerDto;
import com.store.database.DTO.Params.ParamsDto;
import com.store.database.interfaces.CRUDControllerOperations;
import com.store.database.service.CoolerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coolers")
public class CoolerController implements CRUDControllerOperations<CoolerDto, CreateCoolerDto, UpdateCoolerDto> {

    private final CoolerService coolerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CoolerDto> index(
            ParamsDto param,
            @RequestParam(required = false) Double percentage) {

        if (percentage != null) {
            coolerService.increasePrices(percentage);
        }
        return (param != null) ? coolerService.sort(param) : coolerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoolerDto getById(@PathVariable Long id) {
        return coolerService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateCoolerDto dto) {
        coolerService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        coolerService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateCoolerDto dto, @PathVariable Long id) {
        coolerService.update(dto, id);
    }

}

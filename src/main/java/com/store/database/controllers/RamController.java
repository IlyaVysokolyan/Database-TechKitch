package com.store.database.controllers;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.ram.RamCreateDto;
import com.store.database.DTO.ram.RamDto;
import com.store.database.DTO.ram.RamUpdateDto;
import com.store.database.interfaces.CRUDControllerOperations;
import com.store.database.service.RamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/rams")
@RequiredArgsConstructor
public class RamController implements CRUDControllerOperations<RamDto, RamCreateDto, RamUpdateDto> {

    private final RamService ramService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<RamDto> index(
            ParamsDto param,
            @RequestParam(required = false) Double percentage) {

        if (percentage != null) {
            ramService.increasePrices(percentage);
        }
        return (param != null) ? ramService.sort(param) : ramService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RamDto getById(@PathVariable Long id) {
        return ramService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RamCreateDto dto) {
        ramService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ramService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RamUpdateDto dto, @PathVariable Long id) {
        ramService.update(dto, id);
    }

}

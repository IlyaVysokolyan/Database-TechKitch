package com.store.database.controllers;

import com.store.database.DTO.MotherBoard.MotherBoardCreateDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.MotherBoard.UpdateMotherBoardDto;
import com.store.database.DTO.Params.ParamsDto;
import com.store.database.interfaces.CRUDControllerOperations;
import com.store.database.service.MotherBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mb")
public class MotherBoardController implements CRUDControllerOperations<MotherBoardDto, MotherBoardCreateDto, UpdateMotherBoardDto> {

    private final MotherBoardService motherBoardService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<MotherBoardDto> index(
            ParamsDto param,
            @RequestParam(required = false) Double percentage) {

        if (percentage != null) {
            motherBoardService.increasePrices(percentage);
        }
        return (param != null) ? motherBoardService.sort(param) : motherBoardService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MotherBoardDto getById(@PathVariable Long id) {
        return motherBoardService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MotherBoardCreateDto dto) {
        motherBoardService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        motherBoardService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateMotherBoardDto dto, @PathVariable Long id) {
        motherBoardService.update(dto, id);
    }

}

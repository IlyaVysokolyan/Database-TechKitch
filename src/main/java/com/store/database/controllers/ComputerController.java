package com.store.database.controllers;

import com.store.database.DTO.Computer.ComputerCreateDto;
import com.store.database.DTO.Computer.ComputerDto;
import com.store.database.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/computers")
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ComputerDto> index() {
        return computerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComputerDto getById(@PathVariable Long id) {
        return computerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ComputerCreateDto dto) {
        computerService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        computerService.delete(id);
    }


}

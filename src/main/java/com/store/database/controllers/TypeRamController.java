package com.store.database.controllers;

import com.store.database.DTO.GeneralTypeOfComponents.TypeRamDto;
import com.store.database.service.TypeRamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ram-types")
@RequiredArgsConstructor
public class TypeRamController {

    private final TypeRamService typeRamService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TypeRamDto> index() {
        return typeRamService.gelAllTypeRam();
    }

}

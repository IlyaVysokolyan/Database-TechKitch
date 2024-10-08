package com.store.database.controllers;

import com.store.database.DTO.GeneralTypeOfComponents.TypeCoolerDto;
import com.store.database.service.TypeCoolerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cooler-types")
@RequiredArgsConstructor
public class TypeCoolerController {

    private final TypeCoolerService typeCoolerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TypeCoolerDto> index() {
        return typeCoolerService.gelAllTypeCooler();
    }

}

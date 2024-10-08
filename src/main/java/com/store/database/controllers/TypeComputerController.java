package com.store.database.controllers;

import com.store.database.DTO.GeneralTypeOfComponents.TypeComputerDto;
import com.store.database.service.TypeComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/computer-types")
public class TypeComputerController {

    private final TypeComputerService typeComputerService;

    @GetMapping
    public List<TypeComputerDto> show(Model model) {
        return typeComputerService.findAll();
    }
}

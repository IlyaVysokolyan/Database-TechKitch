package com.store.database.service;

import com.store.database.DTO.GeneralTypeOfComponents.TypeCoolerDto;
import com.store.database.mapper.TypeCoolerMapper;
import com.store.database.repository.TypeCoolerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeCoolerService {

    private final TypeCoolerRepository typeCoolerRepo;
    private final TypeCoolerMapper typeCoolerMapper;

    public List<TypeCoolerDto> gelAllTypeCooler() {
        return typeCoolerRepo.findAll().stream().map(typeCoolerMapper::toDto).toList();
    }

}

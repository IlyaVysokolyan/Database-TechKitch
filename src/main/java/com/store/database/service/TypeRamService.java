package com.store.database.service;

import com.store.database.DTO.GeneralTypeOfComponents.TypeRamDto;
import com.store.database.mapper.TypeRamMapper;
import com.store.database.repository.TypeRamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeRamService {

    private final TypeRamRepository typeRamRepo;
    private final TypeRamMapper typeRamMapper;

    public List<TypeRamDto> gelAllTypeRam() {
        return typeRamRepo.findAll().stream().map(typeRamMapper::toDto).toList();
    }

}

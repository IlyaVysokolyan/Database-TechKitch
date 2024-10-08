package com.store.database.service;

import com.store.database.DTO.GeneralTypeOfComponents.TypeComputerDto;
import com.store.database.mapper.TypeComputerMapper;
import com.store.database.repository.TypeComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeComputerService {

    private final TypeComputerRepository typeComputerRepo;
    private final TypeComputerMapper typeComputerMapper;

    public List<TypeComputerDto> findAll() {
        return typeComputerRepo.findAll().stream().map(typeComputerMapper::toDto).toList();
    }


}

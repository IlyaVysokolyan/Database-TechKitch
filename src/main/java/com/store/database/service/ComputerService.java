package com.store.database.service;

import com.store.database.DTO.Computer.ComputerComponentsDto;
import com.store.database.DTO.Computer.ComputerCreateDto;
import com.store.database.DTO.Computer.ComputerDto;
import com.store.database.mapper.ComputerMapper;
import com.store.database.repository.ComputerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ComputerService {

    private final ComputerRepository computerRepo;
    private final ComputerMapper computerMapper;

    public List<ComputerDto> findAll() {
        return computerRepo.findAll().stream().map(computerMapper::toDto).toList();
    }

    public void create(ComputerCreateDto dto) {
        var entity = computerMapper.toEntity(dto);
        computerRepo.save(entity);
    }

    public void delete(long id) {
        computerRepo.deleteById(id);
    }

    public ComputerDto findById(Long id) {
        return computerRepo.findById(id).map(computerMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Computer not found"));
    }
}

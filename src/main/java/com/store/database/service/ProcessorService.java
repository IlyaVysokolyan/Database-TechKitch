package com.store.database.service;


import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.Processor.ProcessorCreateDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.Processor.ProcessorUpdateDto;
import com.store.database.Specification.CPUSpecification;
import com.store.database.interfaces.CRUDServiceOperations;
import com.store.database.mapper.ProcessorMapper;
import com.store.database.repository.ProcessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProcessorService implements CRUDServiceOperations<ProcessorDto, ProcessorCreateDto, ProcessorUpdateDto> {

    private final ProcessorRepository processorRepo;
    private final ProcessorMapper processorMapper;
    private final CPUSpecification specBuild;

    //Метод увеличения цены всего списка в бд
    @Override
    public void increasePrices(double percentage) {
        processorRepo.increasePricesByPercentage(percentage); // Увеличиваем стоимость на указанный процент
    }

    //Сортировка по бренду/модели/цене
    @Override
    public List<ProcessorDto> sort(ParamsDto params) {
        var spec = specBuild.build(params);
        var cpu = processorRepo.findAll(spec);
        return cpu.stream().map(processorMapper::toDto).toList();
    }

    @Override
    public List<ProcessorDto> findAll() {
        return processorRepo.findAll().stream().map(processorMapper::toDto).toList();
    }

    @Override
    public void create(ProcessorCreateDto dto) {
        var entity = processorMapper.toEntity(dto);
        processorRepo.save(entity);
    }

    @Override
    public void update(ProcessorUpdateDto dto, Long id) {
        var entity = processorRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Processor not found"));
        processorMapper.update(dto, entity);
        processorRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        processorRepo.deleteById(id);
    }

    @Override
    public ProcessorDto findById(Long id) {
        return processorRepo.findById(id)
                .map(processorMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Processor not found"));
    }
}

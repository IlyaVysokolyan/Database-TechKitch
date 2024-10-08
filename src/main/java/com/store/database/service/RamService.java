package com.store.database.service;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.ram.RamCreateDto;
import com.store.database.DTO.ram.RamDto;
import com.store.database.DTO.ram.RamUpdateDto;
import com.store.database.Specification.RamSpecification;
import com.store.database.interfaces.CRUDServiceOperations;
import com.store.database.mapper.RamMapper;
import com.store.database.repository.RamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RamService implements CRUDServiceOperations<RamDto, RamCreateDto, RamUpdateDto> {
    private final RamRepository ramRepo;
    private final RamMapper ramMapper;
    private final RamSpecification specBuild;

    //Метод увеличения цены всего списка в бд
    @Override
    public void increasePrices(double percentage) {
        ramRepo.increasePricesByPercentage(percentage); // Увеличиваем стоимость на указанный процент
    }

    //Сортировка по бренду/модели/цене
    @Override
    public List<RamDto> sort(ParamsDto params) {
        var spec = specBuild.build(params);
        var ram = ramRepo.findAll(spec);
        return ram.stream().map(ramMapper::toDto).toList();
    }

    @Override
    public List<RamDto> findAll() {
        return ramRepo.findAll().stream().map(ramMapper::toDto).toList();
    }

    @Override
    public void create(RamCreateDto dto) {
        var entity = ramMapper.toEntity(dto);
        ramRepo.save(entity);
    }

    @Override
    public void update(RamUpdateDto dto, Long id) {
        var entity = ramRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Ram not found"));
        ramMapper.updateCooler(dto, entity);
        ramRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        ramRepo.deleteById(id);
    }

    @Override
    public RamDto findById(Long id) {
        return ramRepo.findById(id).map(ramMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Ram not found"));
    }

}

package com.store.database.service;

import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.Cooler.CreateCoolerDto;
import com.store.database.DTO.Cooler.UpdateCoolerDto;
import com.store.database.DTO.Params.ParamsDto;
import com.store.database.Specification.CoolerSpecification;
import com.store.database.interfaces.CRUDServiceOperations;
import com.store.database.mapper.CoolerMapper;
import com.store.database.repository.CoolerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CoolerService implements CRUDServiceOperations<CoolerDto, CreateCoolerDto, UpdateCoolerDto> {

    private final CoolerRepository coolerRepository;
    private final CoolerMapper coolerMapper;
    private final CoolerSpecification specBuild;

    //Метод увеличения цены всего списка в бд
    @Override
    public void increasePrices(double percentage) {
        coolerRepository.increasePricesByPercentage(percentage); // Увеличиваем стоимость на указанный процент
    }

    //Сортировка по бренду/модели/цене
    @Override
    public List<CoolerDto> sort(ParamsDto params) {
        var spec = specBuild.build(params);
        var cooler = coolerRepository.findAll(spec);
        return cooler.stream().map(coolerMapper::toDto).toList();
    }

    @Override
    public List<CoolerDto> findAll() {
        return coolerRepository.findAll().stream().map(coolerMapper::toDto).toList();
    }

    @Override
    public void create(CreateCoolerDto dto) {
        var entity = coolerMapper.toEntity(dto);
        coolerRepository.save(entity);
    }

    @Override
    public void update(UpdateCoolerDto dto, Long id) {
        var entity = coolerRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cooler not found"));
        coolerMapper.updateCooler(dto, entity);
        coolerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        coolerRepository.deleteById(id);
    }

    @Override
    public CoolerDto findById(Long id) {
        return coolerRepository.findById(id).map(coolerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Cooler not found"));
    }
}

package com.store.database.service;

import com.store.database.DTO.MotherBoard.MotherBoardCreateDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.MotherBoard.UpdateMotherBoardDto;
import com.store.database.DTO.Params.ParamsDto;
import com.store.database.Specification.MBSpecification;
import com.store.database.interfaces.CRUDServiceOperations;
import com.store.database.mapper.MotherBoardMapper;
import com.store.database.repository.MotherBoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MotherBoardService implements CRUDServiceOperations<MotherBoardDto, MotherBoardCreateDto, UpdateMotherBoardDto> {


    private final MotherBoardRepository motherBoardRepo;
    private final MotherBoardMapper motherBoardMapper;
    private final MBSpecification specBuild;

    //Метод увеличения цены всего списка в бд
    @Override
    public void increasePrices(double percentage) {
        motherBoardRepo.increasePricesByPercentage(percentage); // Увеличиваем стоимость на указанный процент
    }

    //Сортировка по бренду/модели/цене
    @Override
    public List<MotherBoardDto> sort(ParamsDto params) {
        var spec = specBuild.build(params);
        var mb = motherBoardRepo.findAll(spec);
        return mb.stream().map(motherBoardMapper::toDto).toList();
    }

    @Override
    public List<MotherBoardDto> findAll() {
        return motherBoardRepo.findAll().stream().map(motherBoardMapper::toDto).toList();
    }

    @Override
    public void create(MotherBoardCreateDto dto) {
        var entity = motherBoardMapper.toEntity(dto);
        motherBoardRepo.save(entity);
    }

    @Override
    public void update(UpdateMotherBoardDto dto, Long id) {
        var entity = motherBoardRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("MotherBoard not found"));
        motherBoardMapper.updateMotherBoard(dto, entity);
        motherBoardRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        motherBoardRepo.deleteById(id);
    }

    @Override
    public MotherBoardDto findById(Long id) {
        return motherBoardRepo.findById(id).map(motherBoardMapper::toDto).orElseThrow(() -> new EntityNotFoundException("MotherBoard not found"));
    }
}

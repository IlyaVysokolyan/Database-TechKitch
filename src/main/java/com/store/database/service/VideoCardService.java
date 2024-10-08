package com.store.database.service;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.VideoCard.UpdateVideoCardDto;
import com.store.database.DTO.VideoCard.VideoCardCreateDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.Specification.GPUSpecification;
import com.store.database.interfaces.CRUDServiceOperations;
import com.store.database.mapper.VideoCardMapper;
import com.store.database.repository.VideoCardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoCardService implements CRUDServiceOperations<VideoCardDTO, VideoCardCreateDto, UpdateVideoCardDto> {

    private final VideoCardRepository videoCardRepository;
    private final VideoCardMapper videoCardMapper;
    private final GPUSpecification specBuild;

    //Метод увеличения цены всего списка в бд
    @Override
    public void increasePrices(double percentage) {
        videoCardRepository.increasePricesByPercentage(percentage); // Увеличиваем стоимость на указанный процент
    }

    //Сортировка по бренду/модели/цене
    @Override
    public List<VideoCardDTO> sort(ParamsDto params) {
        var spec = specBuild.build(params);
        var gpu = videoCardRepository.findAll(spec);
        return gpu.stream().map(videoCardMapper::toDTO).toList();
    }

    @Override
    public List<VideoCardDTO> findAll() {
        return videoCardRepository.findAll().stream()
                .map(videoCardMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void create(VideoCardCreateDto dto) {
        var model = videoCardMapper.toEntity(dto);
        videoCardRepository.save(model);
    }

    @Override
    public void update(UpdateVideoCardDto dto, Long id) {
        var entity = videoCardRepository.findById(id).orElseThrow(null);
        videoCardMapper.update(dto, entity);
        videoCardRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        videoCardRepository.deleteById(id);
    }

    @Override
    public VideoCardDTO findById(Long id) {
        return videoCardRepository.findById(id)
                .map(videoCardMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("VideoCard not found"));
    }
}


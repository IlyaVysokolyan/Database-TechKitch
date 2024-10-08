package com.store.database.mapper;

import com.store.database.DTO.VideoCard.UpdateVideoCardDto;
import com.store.database.DTO.VideoCard.VideoCardCreateDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.model.VideoCard;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoCardMapper {
    VideoCardDTO toDTO(VideoCard entity);


    VideoCard toEntity(VideoCardCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
        // игнорирует изменение поля id в классе
    void update(UpdateVideoCardDto dto, @MappingTarget VideoCard videoCard);

}

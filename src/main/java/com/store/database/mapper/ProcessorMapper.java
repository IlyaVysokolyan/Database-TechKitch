package com.store.database.mapper;

import com.store.database.DTO.Processor.ProcessorCreateDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.Processor.ProcessorUpdateDto;
import com.store.database.model.Processor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessorMapper {

    Processor toEntity(ProcessorCreateDto dto);

    ProcessorDto toDto(Processor entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void update(ProcessorUpdateDto dto, @MappingTarget Processor entity);


}

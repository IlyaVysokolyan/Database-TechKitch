package com.store.database.mapper;

import com.store.database.DTO.GeneralTypeOfComponents.TypeRamDto;
import com.store.database.model.typesComponentsEntity.TypeRam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeRamMapper {

    TypeRamDto toDto(TypeRam entity);

}

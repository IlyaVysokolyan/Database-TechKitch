package com.store.database.mapper;

import com.store.database.DTO.GeneralTypeOfComponents.TypeComputerDto;
import com.store.database.model.typesComponentsEntity.TypeComputer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CoolerMapper.class})
public interface TypeComputerMapper {
    TypeComputerDto toDto(TypeComputer entity);


}

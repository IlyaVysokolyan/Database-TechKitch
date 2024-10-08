package com.store.database.mapper;


import com.store.database.DTO.GeneralTypeOfComponents.TypeCoolerDto;
import com.store.database.model.typesComponentsEntity.TypeCooler;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CoolerMapper.class})
public interface TypeCoolerMapper {
    TypeCoolerDto toDto(TypeCooler typeCooler);

}

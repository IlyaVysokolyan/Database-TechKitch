package com.store.database.mapper;


import com.store.database.DTO.Computer.ComputerCreateDto;
import com.store.database.DTO.Computer.ComputerDto;
import com.store.database.model.Computer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComputerMapper {
    //ComputerMapper INSTANCE = Mappers.getMapper(ComputerMapper.class); - можно сделать статическую переменную даль вызова методов*/

    @Mapping(source = "idProcessor.id", target = "processorDto.id")
    @Mapping(source = "idMotherboard.id", target = "motherBoardDto.id")
    @Mapping(source = "idMotherboard.typeRam.id", target = "motherBoardDto.typeRamId")
    @Mapping(source = "idMotherboard.typeRam.name", target = "motherBoardDto.typeRamName")
    @Mapping(source = "idVideoCard.id", target = "videoCardDTO.id")
    @Mapping(source = "idRam.id", target = "ramDto.id")
    @Mapping(source = "idRam.typeRam.id", target = "ramDto.typeRamId")
    @Mapping(source = "idRam.typeRam.name", target = "ramDto.typeRamName")
    @Mapping(source = "idCooler.id", target = "coolerDto.id")
    @Mapping(source = "idCooler.typeCooler.id", target = "coolerDto.typeCoolerId")
    @Mapping(source = "idCooler.typeCooler.name", target = "coolerDto.coolerTypeName")
    @Mapping(source = "idType.id", target = "typeComputerDto.id")
    @Mapping(source = "idType.name", target = "typeComputerDto.name")
    ComputerDto toDto(Computer entity);

    //Метод ниже нужно переделать как верхний
    @Mapping(target = "idProcessor.id", source = "cpuId")
    @Mapping(target = "idMotherboard.id", source = "motherBoardId")
    @Mapping(target = "idVideoCard.id", source = "videoCardId")
    @Mapping(target = "idRam.id", source = "ramId")
    @Mapping(target = "idCooler.id", source = "coolerId")
    @Mapping(target = "idType.id", source = "typeId")
    Computer toEntity(ComputerCreateDto dto);
}


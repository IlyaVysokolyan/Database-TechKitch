package com.store.database.mapper;

import com.store.database.DTO.MotherBoard.MotherBoardCreateDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.MotherBoard.UpdateMotherBoardDto;
import com.store.database.model.Motherboard;
import com.store.database.model.typesComponentsEntity.TypeRam;
import com.store.database.repository.TypeRamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class MotherBoardMapper {

    @Autowired
    private TypeRamRepository typeRamRepo;

    @Mapping(source = "typeRam.id", target = "typeRamId")
    @Mapping(source = "typeRam.name", target = "typeRamName")
    public abstract MotherBoardDto toDto(Motherboard dto);

    @Mapping(source = "typeRamId", target = "typeRam.id")
    public abstract Motherboard toEntity(MotherBoardCreateDto dto);

    @Mapping(target = "typeRam", source = "typeRamId", qualifiedByName = "getTypeRam")
    public abstract void updateMotherBoard(UpdateMotherBoardDto dto, @MappingTarget Motherboard entity);

    @Named("getTypeRam")
    public TypeRam getTypeRam(Long id) {
        if (id == null) {
            return null;
        } else {
            return typeRamRepo.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("TypeRam not found"));
        }
    }
}

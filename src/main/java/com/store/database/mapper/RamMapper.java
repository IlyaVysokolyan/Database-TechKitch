package com.store.database.mapper;

import com.store.database.DTO.ram.RamCreateDto;
import com.store.database.DTO.ram.RamDto;
import com.store.database.DTO.ram.RamUpdateDto;
import com.store.database.model.Ram;
import com.store.database.model.typesComponentsEntity.TypeRam;
import com.store.database.repository.TypeRamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class RamMapper {

    @Autowired
    private TypeRamRepository typeRamRepo;

    @Mapping(source = "typeRamId", target = "typeRam.id")
    public abstract Ram toEntity(RamCreateDto dto);

    @Mapping(source = "typeRam.id", target = "typeRamId")
    @Mapping(source = "typeRam.name", target = "typeRamName")
    public abstract RamDto toDto(Ram entity);

    @Mapping(target = "typeRam", source = "typeRamId", qualifiedByName = "getTypeRam")
    public abstract void updateCooler(RamUpdateDto dto, @MappingTarget Ram entity);

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

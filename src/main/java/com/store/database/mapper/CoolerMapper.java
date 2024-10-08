package com.store.database.mapper;

import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.Cooler.CreateCoolerDto;
import com.store.database.DTO.Cooler.UpdateCoolerDto;
import com.store.database.model.Cooler;
import com.store.database.model.typesComponentsEntity.TypeCooler;
import com.store.database.repository.TypeCoolerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CoolerMapper {

    @Autowired
    private TypeCoolerRepository typeCoolerRepo;

    @Mapping(source = "typeCoolerId", target = "typeCooler.id")
    public abstract Cooler toEntity(CreateCoolerDto dto);

    @Mapping(source = "typeCooler.id", target = "typeCoolerId")
    @Mapping(source = "typeCooler.name", target = "coolerTypeName")
    public abstract CoolerDto toDto(Cooler cooler);

    @Mapping(target = "typeCooler", source = "typeCoolerId", qualifiedByName = "getTypeCooler")
    public abstract void updateCooler(UpdateCoolerDto dto, @MappingTarget Cooler cooler);

    @Named("getTypeCooler")
    public TypeCooler getTypeCooler(Long id) {
        if (id == null) {
            return null;
        } else {
            return typeCoolerRepo.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("TypeCooler not found"));
        }
    }
}


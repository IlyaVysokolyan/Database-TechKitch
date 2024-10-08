package com.store.database.DTO.GeneralTypeOfComponents;

import java.time.LocalDate;

public record TypeRamDto(Long id,
                         String name,
                         LocalDate createdAt) {
}

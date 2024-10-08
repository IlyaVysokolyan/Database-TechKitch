package com.store.database.DTO.GeneralTypeOfComponents;

import java.time.LocalDate;

public record TypeCoolerDto(Long id,
                            String name,
                            LocalDate createdAt) {
}

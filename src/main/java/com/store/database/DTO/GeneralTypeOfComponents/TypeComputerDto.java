package com.store.database.DTO.GeneralTypeOfComponents;

import java.time.LocalDate;

public record TypeComputerDto(Long id,
                              String name,
                              LocalDate createdAt) {
}

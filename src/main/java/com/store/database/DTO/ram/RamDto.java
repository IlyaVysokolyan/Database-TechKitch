package com.store.database.DTO.ram;

import java.time.LocalDate;

public record RamDto(Long id,
                     String brand,
                     String model,
                     Integer size,
                     Long typeRamId,
                     String typeRamName,
                     Long price,
                     LocalDate createdAt) {
}

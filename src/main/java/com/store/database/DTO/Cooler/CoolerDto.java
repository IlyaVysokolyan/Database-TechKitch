package com.store.database.DTO.Cooler;

import java.time.LocalDate;

public record CoolerDto(Long id,
                        String brand,
                        String model,
                        Integer power,
                        Long typeCoolerId,
                        String coolerTypeName,
                        Long price,
                        LocalDate createdAt) {
}
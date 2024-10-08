package com.store.database.DTO.Cooler;

public record UpdateCoolerDto(String brand,
                              String model,
                              Integer power,
                              Long typeCoolerId,
                              Long price) {
}

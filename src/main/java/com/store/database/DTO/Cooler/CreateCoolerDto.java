package com.store.database.DTO.Cooler;

public record CreateCoolerDto(String brand,
                              String model,
                              Integer power,
                              Long typeCoolerId,
                              Long price) {
}

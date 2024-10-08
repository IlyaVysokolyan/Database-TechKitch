package com.store.database.DTO.ram;

public record RamCreateDto(String brand,
                           String model,
                           Integer size,
                           Long typeRamId,
                           Long price) {
}

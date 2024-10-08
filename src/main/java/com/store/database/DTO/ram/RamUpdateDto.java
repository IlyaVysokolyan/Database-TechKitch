package com.store.database.DTO.ram;

public record RamUpdateDto(String brand,
                           String model,
                           Integer size,
                           Long typeRamId,
                           Long price) {
}

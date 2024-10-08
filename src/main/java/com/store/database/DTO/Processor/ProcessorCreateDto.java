package com.store.database.DTO.Processor;

public record ProcessorCreateDto(String brand,
                                 String model,
                                 String socket,
                                 Long price) {
}

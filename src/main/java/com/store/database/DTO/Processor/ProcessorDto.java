package com.store.database.DTO.Processor;

import java.time.LocalDate;

public record ProcessorDto(Long id,
                           String brand,
                           String model,
                           String socket,
                           Long price,
                           LocalDate createdAt) {
}

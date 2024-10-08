package com.store.database.DTO.VideoCard;

import java.time.LocalDate;

public record VideoCardDTO(Long id,
                           String brand,
                           String model,
                           Integer sizeMemory,
                           Long price,
                           LocalDate createdAt) {
}


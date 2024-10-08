package com.store.database.DTO.VideoCard;

public record VideoCardCreateDto(String brand,
                                 String model,
                                 Integer sizeMemory,
                                 Long price) {
}

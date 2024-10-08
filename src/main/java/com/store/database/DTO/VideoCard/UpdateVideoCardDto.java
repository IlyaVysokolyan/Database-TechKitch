package com.store.database.DTO.VideoCard;

public record UpdateVideoCardDto(Long id,
                                 String brand,
                                 String model,
                                 Integer sizeMemory,
                                 Long price) {
}

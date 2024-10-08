package com.store.database.DTO.MotherBoard;

public record MotherBoardCreateDto(String brand,
                                   String model,
                                   String socket,
                                   Long typeRamId,
                                   Long price) {
}

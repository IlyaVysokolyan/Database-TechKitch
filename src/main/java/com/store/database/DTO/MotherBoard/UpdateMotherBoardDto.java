package com.store.database.DTO.MotherBoard;


public record UpdateMotherBoardDto(String brand,
                                   String model,
                                   String socket,
                                   Long typeRamId,
                                   Long price) {
}

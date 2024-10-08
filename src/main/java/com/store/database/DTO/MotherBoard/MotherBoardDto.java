package com.store.database.DTO.MotherBoard;

import java.time.LocalDate;

public record MotherBoardDto(Long id,
                             String brand,
                             String model,
                             String socket,
                             Long typeRamId,
                             String typeRamName,
                             Long price,
                             LocalDate createdAt) {
}

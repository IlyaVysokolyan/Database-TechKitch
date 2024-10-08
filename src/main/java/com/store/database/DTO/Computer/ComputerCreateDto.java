package com.store.database.DTO.Computer;

public record ComputerCreateDto(Long cpuId,
                                Long motherBoardId,
                                Long videoCardId,
                                Long ramId,
                                Long coolerId,
                                Long typeId) {
}

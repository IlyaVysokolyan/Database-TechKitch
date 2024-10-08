package com.store.database.DTO.Computer;

import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.GeneralTypeOfComponents.TypeComputerDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.DTO.ram.RamDto;

import java.util.List;


public record ComputerComponentsDto(List<ProcessorDto> processors,
                                    List<MotherBoardDto> motherBoards,
                                    List<VideoCardDTO> videoCards,
                                    List<RamDto> rams,
                                    List<CoolerDto> coolers,
                                    List<TypeComputerDto> computerTypes) {
}

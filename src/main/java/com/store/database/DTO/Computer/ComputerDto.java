package com.store.database.DTO.Computer;

import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.GeneralTypeOfComponents.TypeComputerDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.DTO.ram.RamDto;

import java.time.LocalDate;

public record ComputerDto(
        Long id,
        ProcessorDto processorDto,
        MotherBoardDto motherBoardDto,
        VideoCardDTO videoCardDTO,
        CoolerDto coolerDto,
        RamDto ramDto,
        TypeComputerDto typeComputerDto,
        LocalDate createdAt
) {
    //Подсчет стоимости сборки
    public long totalCost() {
        return processorDto.price() +
                motherBoardDto.price() +
                videoCardDTO.price() +
                coolerDto.price() +
                ramDto.price();
    }
}


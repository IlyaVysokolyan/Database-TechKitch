package com.store.database.service.statistics;

import com.store.database.DTO.Computer.ComputerDto;
import com.store.database.DTO.Cooler.CoolerDto;
import com.store.database.DTO.MotherBoard.MotherBoardDto;
import com.store.database.DTO.Processor.ProcessorDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.DTO.ram.RamDto;
import com.store.database.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class IndexService {


    private final ComputerService computerService;
    private final VideoCardService videoCardService;
    private final ProcessorService processorService;
    private final RamService ramService;
    private final CoolerService coolerService;
    private final MotherBoardService motherBoardService;


    //Топ 3 дорогих сборки
    private List<ComputerDto> topThreeComputers() {
        var list = computerService.findAll();
        return list.stream().sorted(Comparator.comparingDouble(ComputerDto::totalCost).reversed())
                .limit(3)
                .toList();
    }

    //Топ 3 дорогих видеокарты
    private List<VideoCardDTO> topThreeVideCards() {
        var list = videoCardService.findAll();
        return list.stream().sorted(Comparator.comparingDouble(VideoCardDTO::price).reversed())
                .limit(3)
                .toList();
    }

    //Топ 3 дорогих ОЗУ
    private List<RamDto> topThreeRams() {
        var list = ramService.findAll();
        return list.stream().sorted(Comparator.comparingDouble(RamDto::price).reversed())
                .limit(3)
                .toList();
    }

    //Подсчет остатков ? // Вопрос: как избежать такого большого количества запросов?
    //Стоимость всего склада?
    private long calculateTotalStockValue() {
        long v = videoCardService.findAll().stream().mapToLong(VideoCardDTO::price).sum();
        long p = processorService.findAll().stream().mapToLong(ProcessorDto::price).sum();
        long r = ramService.findAll().stream().mapToLong(RamDto::price).sum();
        long c = coolerService.findAll().stream().mapToLong(CoolerDto::price).sum();
        long m = motherBoardService.findAll().stream().mapToLong(MotherBoardDto::price).sum();
        return (v + p + r + c + m);
    }

    //Количество компонентов в бд // Как сделать проще?
    private long getVideoCardCount() {
        return videoCardService.findAll().size();
    }

    private long getCpuCount() {
        return processorService.findAll().size();
    }

    private long getCoolerCount() {
        return coolerService.findAll().size();
    }

    private long getMotherBoardCount() {
        return motherBoardService.findAll().size();
    }

    private long getRAMCount() {
        return motherBoardService.findAll().size();
    }

    //Упаковка всей статистики в отдельный объект
    public StatisticOb getStatistic() {
        return StatisticOb.builder()
                .topThreeComputers(topThreeComputers())
                .topThreeVideCards(topThreeVideCards())
                .topThreeRams(topThreeRams())
                .totalStockValue(calculateTotalStockValue())
                .totalStockGPU(getVideoCardCount())
                .totalStockCPU(getCpuCount())
                .totalStockCooler(getCoolerCount())
                .totalStockMotherBoard(getMotherBoardCount())
                .totalStockRam(getRAMCount()).build();
    }


}

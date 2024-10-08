package com.store.database.service.statistics;

import com.store.database.DTO.Computer.ComputerDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.DTO.ram.RamDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class StatisticOb {
    //Топ 3 дорогих сборки
    private List<ComputerDto> topThreeComputers;
    //Топ 3 дорогих видеокарты
    private List<VideoCardDTO> topThreeVideCards;
    //Топ 3 дорогих ОЗУ
    private List<RamDto> topThreeRams;
    //Стоимость всего склада
    private long totalStockValue;
    //Количество Видеокарт
    private long totalStockGPU;
    //Количество процессоров
    private long totalStockCPU;
    //Количество кулеров
    private long totalStockCooler;
    //Количество материнских плат
    private long totalStockMotherBoard;
    //Количество ОЗУ
    private long totalStockRam;
}

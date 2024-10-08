package com.store.database.controllers;

import com.store.database.service.statistics.IndexService;
import com.store.database.service.statistics.StatisticOb;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/index")
public class IndexController {

    private final IndexService indexService;

    @GetMapping()
    public StatisticOb index() {
        return indexService.getStatistic();
    }
}

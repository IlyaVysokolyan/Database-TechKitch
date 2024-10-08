package com.store.database.interfaces;

import com.store.database.DTO.Params.ParamsDto;

import java.util.List;

//D - dto
//C - create
//U - update
public interface CRUDServiceOperations<D, C, U> {

    ////Метод увеличения цены всего списка в бд
    void increasePrices(double percentage);

    List<D> sort(ParamsDto params);

    List<D> findAll();

    void create(C dto);

    void update(U dto, Long id);

    void delete(Long id);

    D findById(Long id);

}

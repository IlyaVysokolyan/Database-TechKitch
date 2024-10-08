package com.store.database.interfaces;

import com.store.database.DTO.Params.ParamsDto;

import java.util.List;

//D - dto
//C - create
//U - update
public interface CRUDControllerOperations<D, C, U> {

    List<D> index(ParamsDto param, Double percentage);

    D getById(Long id);

    void create(C dto);

    void delete(Long id);

    void update(U dto, Long id);
}

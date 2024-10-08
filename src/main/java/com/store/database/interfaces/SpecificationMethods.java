package com.store.database.interfaces;

import com.store.database.DTO.Params.ParamsDto;
import org.springframework.data.jpa.domain.Specification;

//C - class
public interface SpecificationMethods<C> {
    Specification<C> build(ParamsDto params);

    //Фильтр по бренду
    Specification<C> withBrand(String brandCont);

    //Фильтр по модели
    Specification<C> withModel(String modelCont);

    //Фильтрует цену нижу указанного параметра
    Specification<C> withPriceGt(Double priceGt);

    //Фильтрует цену выше указанного параметра
    Specification<C> withPriceLt(Double priceLt);
}

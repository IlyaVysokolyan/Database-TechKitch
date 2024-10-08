package com.store.database.Specification;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.interfaces.SpecificationMethods;
import com.store.database.model.Motherboard;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MBSpecification implements SpecificationMethods<Motherboard> {
    public Specification<Motherboard> build(ParamsDto params) {
        return withPriceGt(params.priceGt())
                .and(withPriceLt(params.priceLt()))
                .and(withBrand(params.brand()))
                .and(withModel(params.model()));
    }

    public Specification<Motherboard> withBrand(String brandCont) {
        return (root, query, cb) -> brandCont == null ? cb.conjunction() : cb.like(cb.lower(root.get("brand")), "%" + brandCont.toLowerCase() + "%");
    }
    //Использование символов % позволяет осуществить поиск по подстроке (например, если пользователь ищет "NVIDIA", то будут возвращены все видеокарты, где в поле brand содержится "NVIDIA").


    //Фильтр по модели
    public Specification<Motherboard> withModel(String modelCont) {
        return (root, query, cb) -> modelCont == null ? cb.conjunction() : cb.like(cb.lower(root.get("model")), "%" + modelCont.toLowerCase() + "%");
    }

    //Фильтрует цену нижу указанного параметра
    public Specification<Motherboard> withPriceGt(Double priceGt) {
        return (root, query, cb) -> priceGt == null ? cb.conjunction() : cb.greaterThan(root.get("price"), priceGt);
    }

    //Фильтрует цену выше указанного параметра
    public Specification<Motherboard> withPriceLt(Double priceLt) {
        return (root, query, cb) -> priceLt == null ? cb.conjunction() : cb.lessThan(root.get("price"), priceLt);
    }
}

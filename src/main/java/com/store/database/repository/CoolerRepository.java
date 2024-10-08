package com.store.database.repository;

import com.store.database.model.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CoolerRepository extends JpaRepository<Cooler, Long>, JpaSpecificationExecutor<Cooler> {
    @Modifying
    @Transactional
    @Query("UPDATE Cooler v SET v.price = v.price * (1 + :percentage / 100)")
    void increasePricesByPercentage(double percentage);
}
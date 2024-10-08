package com.store.database.repository;

import com.store.database.model.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MotherBoardRepository extends JpaRepository<Motherboard,Long>, JpaSpecificationExecutor<Motherboard> {
    @Modifying
    @Transactional
    @Query("UPDATE Motherboard v SET v.price = v.price * (1 + :percentage / 100)")
    void increasePricesByPercentage(double percentage);
}

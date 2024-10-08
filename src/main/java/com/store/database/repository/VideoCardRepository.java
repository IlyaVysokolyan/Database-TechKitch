package com.store.database.repository;

import com.store.database.model.VideoCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface VideoCardRepository extends JpaRepository<VideoCard, Long>, JpaSpecificationExecutor<VideoCard> {

    @Modifying
    @Transactional
    @Query("UPDATE VideoCard v SET v.price = v.price * (1 + :percentage / 100)")
    void increasePricesByPercentage(double percentage);

}

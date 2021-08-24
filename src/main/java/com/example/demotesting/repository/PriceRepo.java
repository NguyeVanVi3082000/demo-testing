package com.example.demotesting.repository;

import com.example.demotesting.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {

    @Modifying
    @Query(value = " update price p set p.price_description = :description  where p.price_id = :priceId " , nativeQuery = true)
    public void updatePriceByPriceId(@Param("priceId") Long priceId, @Param("description") String description);

}

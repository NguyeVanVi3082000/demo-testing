package com.example.demotesting.repository;

import com.example.demotesting.domain.Price;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PriceRepoTest {

    // Clear everything after one test
    @Autowired
    private PriceRepo priceRepo;

    @AfterEach
    void tearDown() {
    }

    @Test
    @Transactional
    void updatePriceByPriceId() {
        //given
        Price price = Price.builder()
                .price(200.0)
                .name("price type 1")
                .description("This is a description")
                .build();
        Price price1 = priceRepo.save(price);
        priceRepo.updatePriceByPriceId(price1.getId(), "This is new description");
        List<Price> all = priceRepo.findAll();
        System.out.println(all);

    }
}
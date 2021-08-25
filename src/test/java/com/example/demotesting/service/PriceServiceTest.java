package com.example.demotesting.service;

import com.example.demotesting.domain.Price;
import com.example.demotesting.repository.PriceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

// Testing service
//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PriceServiceTest {


    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private PriceService priceService;

    PriceServiceTest() {
    }

    @BeforeEach
    void setUp() {
        priceService = new PriceService(priceRepo);
        // given
        Price price1 = Price.builder()
                .id(1l)
                .price(100.0)
                .name("price_1")
                .description("This is description for price 1")
                .build();
        Price price2 = Price.builder()
                .id(2l)
                .price(200.0)
                .name("price_2")
                .description("This is description for price 2")
                .build();

        priceRepo.save(price1);
        priceRepo.save(price2);
    }

    @Test
    void savePrice() {
        assertNotNull(priceService);
        // given
        Price price = Price.builder()
                .price(100.0)
                .name("Price 1")
                .description("This is description")
                .build();
        priceService.savePrice(price);
        verify(priceRepo).findAll();

    }

    @Test
    void updatePriceDescription() {
    }


    // Test With Service -> Note on @Transactional
    @Test
    @Transactional
    void updatePriceNameByPriceIdAndName() {
        List<Price> input = Arrays.asList(
                Price.builder()
                        .id(1l)
                        .price(100.0)
                        .name("price_1_1")
                        .description("This is description for price 1")
                        .build(), Price.builder()
                        .id(2l)
                        .price(200.0)
                        .name("price_2")
                        .description("This is description for price 2")
                        .build());

        // when
        priceService.updatePriceName(input);

    }

    // Testing with multiple database operation
    @Test
    @Transactional
    void updatePriceNameByPriceIdAndNameAndSaveNewPrice() {
        List<Price> input = Arrays.asList(
                Price.builder()
                        .id(1l)
                        .price(100.0)
                        .name("price_1_1")
                        .description("This is description for price 1")
                        .build(), Price.builder()
                        .id(2l)
                        .price(200.0)
                        .name("price_2")
                        .description("This is description for price 2")
                        .build(), Price.builder()
                        .id(3l)
                        .price(200.0)
                        .name("price_2")
                        .description("This is description for price 2")
                        .build());

        // when
        priceService.updatePriceName(input);

    }

}
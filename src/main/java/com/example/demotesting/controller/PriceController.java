package com.example.demotesting.controller;

import com.example.demotesting.domain.Price;
import com.example.demotesting.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping(value = "/prices/save")
    public void saveData(@RequestBody Price price) {
        priceService.savePrice(price);
    }
}

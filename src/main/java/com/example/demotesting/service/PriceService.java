package com.example.demotesting.service;

import com.example.demotesting.domain.Price;
import com.example.demotesting.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PriceService {

    @Autowired
    private PriceRepo priceRepo;

    public Price savePrice(Price price) {
        Price save = priceRepo.save(price);
        return save;
    }

    @Transactional
    public void updatePriceDescription(Long priceId, String priceDescription) {
        priceRepo.updatePriceByPriceId(priceId, priceDescription);
    }
}

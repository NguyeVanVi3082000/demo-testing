package com.example.demotesting.service;

import com.example.demotesting.domain.Price;
import com.example.demotesting.repository.PriceRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceService {

    @Autowired
    private final PriceRepo priceRepo;

    public Price savePrice(Price price) {
        Price save = priceRepo.save(price);
        return save;
    }

    @Transactional
    public void updatePriceDescription(Long priceId, String priceDescription) {
        priceRepo.updatePriceByPriceId(priceId, priceDescription);
    }


    public void updatePriceName(List<Price> priceList) {
        // validate price
        for (Price price : priceList) {
            Optional<Price> byId = priceRepo.findById(price.getId());
            if (!byId.isPresent()) {
                System.out.println("Price with "+price.getId()+" is invalid");
                priceRepo.save(price);
            } else {
                Price price1 = byId.get();
                if (!price.getName().equalsIgnoreCase(price1.getName())) {
                    priceRepo.updatePriceNameByPriceId(price.getName(), price.getId());
                }
            }
        }
    }
}

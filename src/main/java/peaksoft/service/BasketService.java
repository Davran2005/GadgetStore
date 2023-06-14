package peaksoft.service;

import peaksoft.dto.Basket.BasketRequest;
import peaksoft.dto.SimpleResponse;


public interface BasketService {

    SimpleResponse saveBasket(BasketRequest basketRequest);
    SimpleResponse deleteBasketById(Long id);
}

package peaksoft.service;

import peaksoft.dto.basket.BasketRequest;
import peaksoft.dto.basket.BasketResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface BasketService {
    SimpleResponse saveBasket(String email,BasketRequest basketRequest);
    List<BasketResponse> getAllBasket(Long userId);
    BasketResponse getBasketById(Long id);
    SimpleResponse updateBasketById(Long id,BasketRequest basketRequest);
    SimpleResponse deleteById(Long id);
}

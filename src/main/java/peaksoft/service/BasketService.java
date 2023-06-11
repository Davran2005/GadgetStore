package peaksoft.service;

import peaksoft.dto.basket.AllBasketResponse;
import peaksoft.dto.basket.BasketRequest;
import peaksoft.dto.basket.BasketResponse;
import peaksoft.dto.basket.BasketResponseAddAndRemove;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Product;
import peaksoft.entity.User;

import java.util.List;

public interface BasketService {
    SimpleResponse saveBasket(String email,BasketRequest basketRequest);
    BasketResponse getBasket();
    BasketResponseAddAndRemove addToBasket(User user, Product product);
    BasketResponseAddAndRemove removeFromBasket(User user, Product product);

}

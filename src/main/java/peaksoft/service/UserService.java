package peaksoft.service;

import peaksoft.dto.Basket.GetAllUsersBasketResponse;
import peaksoft.dto.Favorite.FavoriteResponse;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.User.UserRequest;
import peaksoft.dto.User.UserResponse;


import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    SimpleResponse saveUser(UserRequest userRequest);
    SimpleResponse updateUser(Long id, UserRequest userRequest);
    UserResponse getUserById(Long id);
    SimpleResponse deleteUserById(Long id);
    SimpleResponse addOrDeleteFavorite(Long productId);
    List<FavoriteResponse> getAllUsersFavorites();
    SimpleResponse addOrDeleteProductsToBasket(Long productId);
    GetAllUsersBasketResponse getUsersAllBasketsProduct();
    SimpleResponse deleteAllProductsFromBasket();

}

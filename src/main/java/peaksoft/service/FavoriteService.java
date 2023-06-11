package peaksoft.service;

import peaksoft.dto.favorite.FavoriteRequest;
import peaksoft.dto.favorite.FavoriteResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Product;
import peaksoft.entity.User;

import java.util.List;

public interface FavoriteService {
    SimpleResponse saveFavorite(Long userId,FavoriteRequest favoriteRequest);
    List<FavoriteResponse> getAllFavorite();
    FavoriteResponse addToFavorites(User user, Product product);
    FavoriteResponse removeFromFavorites(User user, Product product);
    FavoriteResponse getFavoriteByProductAndUser(String email);
}

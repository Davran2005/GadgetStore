package peaksoft.service;

import peaksoft.dto.favorite.FavoriteRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface FavoriteService {
    SimpleResponse saveFavorite(FavoriteRequest favoriteRequest);
    List<UserResponse> getAllFavorite();
    UserResponse getFavoriteById(Long id);
    SimpleResponse updateFavoriteById(Long id,FavoriteRequest favoriteRequest);
    SimpleResponse deleteById(Long id);
}

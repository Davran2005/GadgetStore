package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.favorite.FavoriteRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Basket;
import peaksoft.entity.Favorite;
import peaksoft.entity.User;
import peaksoft.repository.FavoriteRepository;
import peaksoft.repository.ProductRepository;
import peaksoft.service.FavoriteService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;
//    User user = userRepository.getUserByEmail(email).orElseThrow(() -> new
//            NoSuchElementException("User with email: %s not found".formatted(email)));
//    Basket basket = Basket.builder().user(user).build();
//        user.setBasket(basket);
//        basketRepository.save(basket);
//        return SimpleResponse.builder()
//                .status(HttpStatus.OK)
//                .massage("Успешно")
//                .build();
    @Override
    public SimpleResponse saveFavorite(Long id, FavoriteRequest favoriteRequest) {
productRepository.getProducts1ById(id).orElseThrow(()->new NullPointerException("Product with id: " + id + "is not found"))
        return null;
    }

    @Override
    public List<UserResponse> getAllFavorite() {
        return null;
    }

    @Override
    public UserResponse getFavoriteById(Long id) {
        return null;
    }

    @Override
    public SimpleResponse updateFavoriteById(Long id, FavoriteRequest favoriteRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        return null;
    }
}

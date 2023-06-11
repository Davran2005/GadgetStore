package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.favorite.FavoriteRequest;
import peaksoft.dto.favorite.FavoriteResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.entity.Favorite;
import peaksoft.entity.Product;
import peaksoft.entity.User;
import peaksoft.repository.FavoriteRepository;
import peaksoft.repository.ProductRepository;
import peaksoft.service.FavoriteService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;


    @Override
    public SimpleResponse saveFavorite(Long userId, FavoriteRequest favoriteRequest) {
        Product product = productRepository.findById(userId).orElseThrow(() -> new NullPointerException("Product with id: " + userId + "is not found"));
        Favorite build = Favorite.builder().product(product).build();
        product.setFavorites(List.of(build));
        favoriteRepository.save(build);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public List<FavoriteResponse> getAllFavorite() {
        return favoriteRepository.getAllFavorite();
    }

    public FavoriteResponse addToFavorites(User user, Product product) {
        Favorite favoriteProduct = new Favorite();
        favoriteProduct.setUser(user);
        favoriteProduct.setProduct(product);
        favoriteRepository.save(favoriteProduct);
        return FavoriteResponse.builder()
                .userId(favoriteProduct.getUser().getId())
                .productId(favoriteProduct.getProduct().getId())
                .build();
    }

    public FavoriteResponse removeFromFavorites(User user, Product product) {
        Favorite favoriteProduct = new Favorite();
        favoriteRepository.deleteByUserAndProduct(user, product);
        return FavoriteResponse.builder()
                .userId(favoriteProduct.getUser().getId())
                .productId(favoriteProduct.getProduct().getId())
                .build();
    }

    @Override
    public FavoriteResponse getFavoriteByProductAndUser(String email) {
        return favoriteRepository.getFavoriteByProductAndUser(email);
    }
}

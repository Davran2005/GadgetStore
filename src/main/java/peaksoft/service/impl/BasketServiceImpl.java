package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import peaksoft.dto.basket.BasketRequest;
import peaksoft.dto.basket.BasketResponse;
import peaksoft.dto.basket.BasketResponseAddAndRemove;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.entity.Basket;
import peaksoft.entity.Product;
import peaksoft.entity.User;
import peaksoft.repository.BasketRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.BasketService;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@Transactional
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;

    @Override
    public SimpleResponse saveBasket(String email, BasketRequest basketRequest) {
        User user = userRepository.getUserByEmail(email).orElseThrow(() -> new
                NoSuchElementException("User with email: %s not found".formatted(email)));
        Basket basket = Basket.builder().user(user).build();
        user.setBasket(basket);
        basketRepository.save(basket);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public BasketResponse getBasket() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.getUserByEmail(email).orElseThrow(() -> new NoSuchElementException("User email: %s not found".formatted(email)));
        return basketRepository.getBasket(user.getId());
    }

    @Override
    public BasketResponseAddAndRemove addToBasket(User user, Product product) {
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setProducts(List.of(product));
        basketRepository.save(basket);
        return BasketResponseAddAndRemove.builder()
                .id(basket.getId())
                .productId(basket.getProducts().get(0).getId())
                .userId(basket.getUser().getId())
                .build();
    }

    @Override
    public BasketResponseAddAndRemove removeFromBasket(User user, Product product) {
        Basket basket = new Basket();
        basketRepository.deleteByUserAndProduct(user, product);
        return BasketResponseAddAndRemove.builder()
                .id(basket.getId())
                .productId(basket.getProducts().get(0).getId())
                .build();

    }
}

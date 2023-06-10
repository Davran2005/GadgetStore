package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.basket.BasketRequest;
import peaksoft.dto.basket.BasketResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Basket;
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
    public List<BasketResponse> getAllBasket(Long id) {
        return basketRepository.getAllBasket(id);
    }

    @Override
    public BasketResponse getBasketById(Long id) {
        return basketRepository.getBasketById(id).orElseThrow(()->new NullPointerException("Basket with id: " + id + "is not found!"));
    }

    @Override
    public SimpleResponse updateBasketById(Long id, BasketRequest basketRequest) {
        Basket basket = basketRepository.findById(id).orElseThrow(() -> new NullPointerException("Basket with id: " + id + "is not found!"));
        return null;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        Basket basket = basketRepository.findById(id).orElseThrow(() -> new NullPointerException("Basket with id: " + id + "is not found!"));
        basketRepository.delete(basket);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }
}

package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.Basket.BasketRequest;
import peaksoft.dto.SimpleResponse;

import peaksoft.service.BasketService;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    @Override
    public SimpleResponse saveBasket(BasketRequest basketRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteBasketById(Long id) {
        return null;
    }
}

package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.product.ProductRequest;
import peaksoft.dto.product.ProductResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.entity.Product;
import peaksoft.repository.ProductRepository;
import peaksoft.service.ProductService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public SimpleResponse saveProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setImages(productRequest.getImages());
        product.setCharacteristic(productRequest.getCharacteristic());
        product.setIsFavorite(false);
        product.setMadeIn(productRequest.getMadeIn());
        productRepository.save(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.getProductsById(id).orElseThrow(()-> new NullPointerException("Product with id: " + id + "is not found!"));
    }

    @Override
    public SimpleResponse updateProductById(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product with id: " + id + "is not found!"));
        product.setName(productRequest.getName());
        product.setImages(productRequest.getImages());
        product.setCharacteristic(productRequest.getCharacteristic());
        product.setMadeIn(productRequest.getMadeIn());
        productRepository.save(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product with id: " + id + "is not found!"));
productRepository.delete(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }
}

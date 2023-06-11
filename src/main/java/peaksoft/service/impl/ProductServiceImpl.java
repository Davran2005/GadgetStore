package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.product.EntityResponse;
import peaksoft.dto.product.ProductRequest;
import peaksoft.dto.product.ProductResponse;
import peaksoft.dto.product.SortResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.entity.Product;
import peaksoft.repository.ProductRepository;
import peaksoft.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        return productRepository.getProductsById(id).orElseThrow(() -> new NullPointerException("Product with id: " + id + "is not found!"));
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

    @Override
    public List<ProductResponse> getFiltrCategory(String category) {
        Product product = new Product();
        if (category.equals("LAPTOP")) {
            return productRepository.info1();
        } else if (category.equals("PHONE")) {
            return productRepository.info2();
        } else if (category.equals("HEADPHONES")) {
            return productRepository.info3();
        } else if (category.equals("SMART_WATCH")) {
            return productRepository.info4();
        }
        return Collections.singletonList(ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .images(product.getImages())
                .characteristic(product.getCharacteristic())
                .isFavorite(product.getIsFavorite())
                .madeIn(product.getMadeIn())
                .build());
    }

    @Override
    public EntityResponse sort(String askOnDesc) {
        List<SortResponse> sortResponses = new ArrayList<>();
        if (askOnDesc.equalsIgnoreCase("ask")) {
            List<Product> products = productRepository.findAll().stream().sorted(Comparator.comparing(Product::getPrice)).toList();
            for (Product p : products) {
                sortResponses.add(new SortResponse(p.getId(), p.getName(), p.getPrice(), p.getImages(), p.getCharacteristic(), p.getIsFavorite(), p.getMadeIn()));
            }
        } else {
            List<Product> products = productRepository.findAll().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
            for (Product p : products) {
                sortResponses.add(new SortResponse(p.getId(), p.getName(), p.getPrice(), p.getImages(), p.getCharacteristic(), p.getIsFavorite(), p.getMadeIn()));
            }
        }
        return EntityResponse.builder()
                .objectList(sortResponses)
                .build();
    }

    @Override
    public ProductResponse ProductAndComments(Long productId) {
        return productRepository.productAndComments(productId);
    }

    @Override
    public ProductResponse productCountLike(Long productId) {
        return productRepository.productCountLike(productId);
    }
}

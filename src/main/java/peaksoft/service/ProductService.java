package peaksoft.service;

import peaksoft.dto.product.EntityResponse;
import peaksoft.dto.product.ProductRequest;
import peaksoft.dto.product.ProductResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface ProductService {
    SimpleResponse saveProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();

    ProductResponse getProductById(Long id);

    SimpleResponse updateProductById(Long id, ProductRequest productRequest);

    SimpleResponse deleteById(Long id);

    List<ProductResponse> getFiltrCategory(String category);

    EntityResponse sort(String askOnDesc);

    ProductResponse ProductAndComments(Long productId);

    ProductResponse productCountLike(Long productId);
}

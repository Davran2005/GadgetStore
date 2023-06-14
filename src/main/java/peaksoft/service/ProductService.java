package peaksoft.service;

import peaksoft.dto.Product.AllProductResponse;
import peaksoft.dto.Product.ProductRequest;
import peaksoft.dto.Product.ProductResponse;
import peaksoft.dto.SimpleResponse;

import peaksoft.enums.Category;

import java.util.List;

public interface ProductService {
  List<AllProductResponse> getAllProducts(Category category, int price);
  SimpleResponse saveProduct(ProductRequest productRequest, Long brandId);
  SimpleResponse updateProduct(Long id, ProductRequest productRequest);
  ProductResponse getProductById(Long id);
  SimpleResponse deleteProductById(Long id);

}

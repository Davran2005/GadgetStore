package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.product.EntityResponse;
import peaksoft.dto.product.ProductRequest;
import peaksoft.dto.product.ProductResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {
    private final ProductService productService;

    @PostMapping
    SimpleResponse saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @GetMapping
    List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    SimpleResponse updateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProductById(id, productRequest);
    }

    @DeleteMapping("/{id}")
    SimpleResponse deleteById(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @GetMapping("/filtr/{category}")
    List<ProductResponse> getFiltrCategory(@PathVariable String category) {
        return productService.getFiltrCategory(category);
    }

    @GetMapping("/sort/{askOnDesc}")
    EntityResponse sort(@PathVariable String askOnDesc) {
        return productService.sort(askOnDesc);
    }

    @GetMapping("/comm/{productId}")
    ProductResponse ProductAndComments(@PathVariable Long productId) {
        return productService.ProductAndComments(productId);
    }

    @GetMapping("/like/{productId}")
    ProductResponse productCountLike(Long productId) {
        return productService.productCountLike(productId);
    }
}

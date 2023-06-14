package peaksoft.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.Product.AllProductResponse;
import peaksoft.dto.Product.ProductRequest;
import peaksoft.dto.Product.ProductResponse;
import peaksoft.enums.Category;
import peaksoft.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductAPI {
    private final ProductService service;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping
    @Operation(description = "token", summary = "get all product")
    public List<AllProductResponse> getAllProducts(@RequestParam String category, @RequestParam int price) {
        Category disiredCategory = Category.valueOf(category.toUpperCase());
        return service.getAllProducts(disiredCategory, price);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @Operation(description = "token", summary = "save product  brandId")

    public SimpleResponse saveProduct(@RequestBody ProductRequest productRequest,@RequestParam Long brandId) {
        return service.saveProduct(productRequest, brandId);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    @Operation(description = "token", summary = "update product id")

    public SimpleResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        return service.updateProduct(id, productRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("{id}")
    @Operation(description = "token", summary = "product by id")

    public ProductResponse getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    @Operation(description = "token", summary = "delete id")

    public SimpleResponse deleteProduct(@PathVariable Long id){
        return service.deleteProductById(id);
    }
}

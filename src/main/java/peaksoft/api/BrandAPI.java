package peaksoft.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.Brand.BrandRequest;
import peaksoft.dto.Brand.BrandResponse;
import peaksoft.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandAPI {
    private final BrandService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    @Operation(description = "token", summary = "Get All Brand")
    public List<BrandResponse> getAllBrands(){
        return service.getAllBrands();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @Operation(description = "token", summary = "save Brand")
    public SimpleResponse saveBrand(@RequestBody BrandRequest brandRequest){
        return service.saveBrand(brandRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    @Operation(description = "token", summary = "assign product to brand")
    public SimpleResponse assignProductToBrand(@RequestParam Long productId,@PathVariable Long id){
        return service.assignProductToBrand(productId,id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    @Operation(description = "token", summary = "delete brand")
    public SimpleResponse deleteBrand(@PathVariable Long id){
        return service.deleteBrandById(id);
    }

}

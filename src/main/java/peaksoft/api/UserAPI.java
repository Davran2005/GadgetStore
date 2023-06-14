package peaksoft.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.Basket.GetAllUsersBasketResponse;
import peaksoft.dto.Favorite.FavoriteResponse;
import peaksoft.dto.User.UserRequest;
import peaksoft.dto.User.UserResponse;
import peaksoft.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    @Operation(description = "token", summary = "get all user ")
    public List<UserResponse> getAllUsers(){
        return service.getAllUsers();
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @PutMapping("{id}")
    @Operation(description = "token", summary = "update user id")
    public SimpleResponse updateUser(@PathVariable Long id,@RequestBody UserRequest userRequest){
        return service.updateUser(id, userRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("{id}")
    @Operation(description = "token", summary = "get user by id")
    public UserResponse getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @DeleteMapping("{id}")
    @Operation(description = "token", summary = "delete user id")
    public SimpleResponse deleteUserById(@PathVariable Long id){
        return service.deleteUserById(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/add")
    @Operation(description = "token", summary = "delete Or Add Products To Favorite")
    public SimpleResponse deleteOrAddProductsToFavorite(@RequestParam Long id){
        return service.addOrDeleteFavorite(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/favorites")
    @Operation(description = "token", summary = " get All Users Favorites")
    public List<FavoriteResponse> getAllUsersFavorites(){
        return service.getAllUsersFavorites();
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/basket")
    @Operation(description = "token", summary = "delete Or Add Products To Basket")
    public SimpleResponse deleteOrAddProductsToBasket(@RequestParam Long id){
        return service.addOrDeleteProductsToBasket(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/basketsProduct")
    @Operation(description = "token", summary = "get All Users Product From Basket")
    public GetAllUsersBasketResponse getAllUsersProductFromBasket(){
        return service.getUsersAllBasketsProduct();
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/clean")
    @Operation(description = "token", summary = "delete Users Product From Basket")
    public SimpleResponse deleteUsersProductFromBasket(){
        return service.deleteAllProductsFromBasket();
    }
}

package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.favorite.FavoriteRequest;
import peaksoft.dto.favorite.FavoriteResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.entity.Product;
import peaksoft.entity.User;
import peaksoft.service.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteApi {
    private final FavoriteService favoriteService;

    @PostMapping("/{userId}")
    SimpleResponse saveFavorite(@PathVariable Long userId, @RequestBody FavoriteRequest favoriteRequest) {
        return favoriteService.saveFavorite(userId, favoriteRequest);
    }
@GetMapping
    List<FavoriteResponse> getAllFavorite(){
        return favoriteService.getAllFavorite();
    }
@PostMapping("/add")
    FavoriteResponse addToFavorites(User user, Product product){
        return favoriteService.addToFavorites(user, product);
    }
@DeleteMapping("/remove")
    FavoriteResponse removeFromFavorites(User user, Product product){
        return favoriteService.removeFromFavorites(user, product);
    }
@GetMapping("/get")
    FavoriteResponse getFavoriteByProductAndUser(@RequestBody String email){
        return favoriteService.getFavoriteByProductAndUser(email);
    }
}

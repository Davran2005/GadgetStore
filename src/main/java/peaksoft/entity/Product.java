package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Category;

import java.util.List;
@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_seq",allocationSize = 1)
    private Long id;
    private String name;
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    private Category category;

    public Product(String name, List<String> images, String characteristic, Boolean isFavorite, String madeIn, Category category) {
        this.name = name;
        this.images = images;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
        this.category = category;
    }
}

package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Category;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

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
    @CollectionTable(name = "images")
    @ElementCollection
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(mappedBy = "products",cascade = {DETACH,REFRESH,MERGE,REMOVE})
    private List<Basket>baskets;
    @ManyToOne(cascade = {DETACH,MERGE,REMOVE,REFRESH})
    private Brand brand;
    @OneToMany(mappedBy = "product",cascade = {DETACH,REFRESH,MERGE,REMOVE})
    private List<Comment>comments;
    @OneToMany(mappedBy = "product",cascade = {DETACH,REFRESH,MERGE,REMOVE})
    private List<Favorite>favorites;

    public Product(String name, List<String> images, String characteristic, Boolean isFavorite, String madeIn, Category category) {
        this.name = name;
        this.images = images;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
        this.category = category;
    }
}

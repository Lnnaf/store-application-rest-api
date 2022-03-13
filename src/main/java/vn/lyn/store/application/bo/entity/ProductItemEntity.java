package vn.lyn.store.application.bo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PRODUCT_ITEM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;

    @OneToOne()
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductTypeEntity productType;

    private Date mfgDate;
    private Long price;
    private String description;
    private Boolean isFreeDelivery;

    @OneToMany()
    @Column(name = "product_item_size")
    private List<SizeEntity> sizeCollections;

    private Boolean isAvailable;
    private int amount;
    private String color;

}

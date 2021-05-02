package az.company.turbo.entity;


import az.company.turbo.entity.enums.DriveEnum;
import az.company.turbo.entity.enums.Valyuta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product", schema = "turbo")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = BrandEntity.class)
    @JoinColumn(name = "brend_id", referencedColumnName = "id")
    private BrandEntity brand;
    @ManyToOne(targetEntity = ModelEntity.class)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity model;
    @ManyToOne(targetEntity = FuelTypeEntity.class)
    @JoinColumn(name = "fuel_id", referencedColumnName = "id")
    private FuelTypeEntity fuelType;//yanacaq novu
    private DriveEnum drive;//outrun

    private Short releaseDate;//istehsal tarixi

    //private BigDecimal price;//qiymeti
    private Valyuta valyuta;
    private int mileage;//yuruyusu
    private Short enginePower;//muherrik gucu
    private boolean creditStatus;//kredit statusu
    private boolean barterStatus;
    private String description;
    private String photo;
    @ManyToOne(targetEntity = ContactInfoEntity.class)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactInfoEntity contactInfo;
    @ManyToOne(targetEntity = CityEntity.class)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;
}

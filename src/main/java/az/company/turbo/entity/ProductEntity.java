package az.company.turbo.entity;


import az.company.turbo.dto.enums.DriveEnum;
import az.company.turbo.dto.enums.Valyuta;
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
    private Integer id;
    @ManyToOne(targetEntity = ModelEntity.class)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity model;
    @ManyToOne(targetEntity = FuelTypeEntity.class)
    @JoinColumn(name = "fuel_id", referencedColumnName = "id")
    private FuelTypeEntity fuelType;//yanacaq novu
    @Enumerated(EnumType.STRING)
    @Column(name = "drive")
    private DriveEnum drive;//outrun

    private Short releaseDate;//istehsal tarixi
    @Column(length = 19)
    private BigDecimal price;//qiymeti
    @Enumerated(EnumType.STRING)
    private Valyuta valyuta;
    @Column(name = "mile_age")
    private int mileage;//yuruyusu
    @Column(name = "engine_power")
    private Short enginePower;//muherrik gucu
    @Column(name = "credit_status")
    private boolean creditStatus;//kredit statusu
    @Column(name = "barter_status")
    private boolean barterStatus;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @ManyToOne(targetEntity = ContactInfoEntity.class)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactInfoEntity contactInfo;




//    @ManyToOne(targetEntity = CityEntity.class)
//    @JoinColumn(name = "city_id", referencedColumnName = "id")
//    private CityEntity city;
}

package az.company.turbo.dto;


import az.company.turbo.entity.enums.DriveEnum;
import az.company.turbo.entity.enums.Valyuta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private int id;
    @NotBlank(message = "Brand name can't be empty or null")
    private BrandDto brand;
    @NotBlank(message = "model name can't be empty or null")
    private ModelDto mode;
    @NotBlank(message = "fuel name can't be empty or null")
    private FuelTypeDto fuelType;//yanacaq novu
    @NotBlank(message = "drive  can't be empty or null")
    @Enumerated(EnumType.STRING)
    private DriveEnum drive;//oturucu
    @NotBlank(message = "release Date  can't be empty or null")
    private Short releaseDate;//istehsal tarixi
    // @NotBlank(message =" price can't be empty or null")
    //private BigDecimal price;//qiymeti
    @NotBlank(message = "valyuta can't be empty or null")
    @Enumerated(EnumType.STRING)
    private Valyuta valyuta;
    @NotBlank(message = "mileage  can't be empty or null")
    private int mileage;//yuruyusu
    @NotBlank(message = "engnePower  can't be empty or null")
    private Short enginePower;//muherrik gucu
    private boolean creditStatus;//kredit statusu
    private boolean barter;
    private String desc;
    private String photo;
    @NotBlank(message = "contact info  can't be empty or null")
    private ContactInfoDto contactInfoDto;


}

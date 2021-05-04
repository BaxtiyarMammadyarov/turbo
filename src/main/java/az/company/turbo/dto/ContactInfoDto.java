package az.company.turbo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactInfoDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private CityDto city;
}

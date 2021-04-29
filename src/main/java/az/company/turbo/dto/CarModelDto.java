package az.company.turbo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarModelDto {
    private int id;
    private String name;
    private CarBrendDto carBrendDto;
}

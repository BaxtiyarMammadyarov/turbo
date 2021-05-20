package az.company.turbo.dto.clientdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Districts {
    private String Status;
    private String StatusMessage = null;
    List<Object> Response = new ArrayList<>();


}
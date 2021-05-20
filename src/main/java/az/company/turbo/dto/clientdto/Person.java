package az.company.turbo.dto.clientdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person {

    private int id;

    private String name;

    private String Surname;

    private int age;

    private Address address;

   private List<Phone> phones;

   private LocalDate birthDate;

}

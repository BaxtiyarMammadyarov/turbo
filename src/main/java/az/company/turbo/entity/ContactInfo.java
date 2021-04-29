package az.company.turbo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact_info")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(targetEntity = City.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",referencedColumnName ="id" )
    private City city;

}

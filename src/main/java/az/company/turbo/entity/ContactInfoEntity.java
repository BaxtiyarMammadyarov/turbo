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
@Table(name = "contact_info",schema = "turbo")
public class ContactInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "email",nullable = false,length =50)
    private String email;
    @ManyToOne(targetEntity = CityEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",referencedColumnName ="id" )
    private CityEntity cityEntity;


}

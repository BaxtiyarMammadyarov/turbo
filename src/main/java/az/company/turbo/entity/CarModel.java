package az.company.turbo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(targetEntity = CarBrend.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "Brend_id",referencedColumnName = "id")
    private CarBrend carBrend;
}

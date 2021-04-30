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
@Table(name = "model",schema = "turbo")
public class ModelEntiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,length = 50)
    private String name;
    @ManyToOne(targetEntity = BrandEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "Brend_id",referencedColumnName = "id")
    private BrandEntity brandEntity;
}

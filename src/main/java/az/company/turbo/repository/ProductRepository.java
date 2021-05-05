package az.company.turbo.repository;


import az.company.turbo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    ProductEntity[] findAllByBrandId(int id);

    boolean existsByBrandId(int id);
    boolean existsByBrandIdAndModelId(int id, int id1);

    ProductEntity[] findAllByBrandIdAndModelId(int id, int id1);

    boolean existsByReleaseDateBetween(Short dateMin, Short dateMax);

    ProductEntity[] findAllByReleaseDateBetween(Short dateMin, Short dateMax);

    //boolean existsByPriceBetween(BigDecimal min, BigDecimal max);
    //ProductEntity[] findAllByPirceBetween(BigDecimal min, BigDecimal max);


    boolean existsByCreditStatus(boolean creditStatus);

    ProductEntity[] findAllByCreditStatus(boolean creditStatus);


}

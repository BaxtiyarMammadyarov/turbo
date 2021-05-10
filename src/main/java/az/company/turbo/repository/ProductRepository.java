package az.company.turbo.repository;



import az.company.turbo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {



    @Query(value = "select * from product where product.brand_id=?1",nativeQuery = true)
    List<ProductEntity> findProductByBrandId (Integer id);

    List<ProductEntity> findProductByModelId(Integer id);

    List<ProductEntity> findPoductByPriceBetween(BigDecimal num1, BigDecimal num2);

    List<ProductEntity> findProductByModelNameAndPriceBetween(String name, BigDecimal min, BigDecimal max);
}

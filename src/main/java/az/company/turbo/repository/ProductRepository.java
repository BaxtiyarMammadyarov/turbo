package az.company.turbo.repository;



import az.company.turbo.dto.ProductDto;
import az.company.turbo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {




    @Query(value = "select * from turbo.product where product.model_id=?1",nativeQuery = true)
    List<ProductEntity> findProductByModelId(Integer id);

    List<ProductEntity> findPoductByPriceBetween(BigDecimal num1, BigDecimal num2);

    List<ProductEntity> findProductByModelNameAndPriceBetween(String name, BigDecimal min, BigDecimal max);
    @Query(value = "select * from turbo.product where product.brand_id=?1",nativeQuery = true)
    List<ProductEntity> findProductBrandId(int id);
    @Query(value = "select * from turbo.product where brand_id=?1 and model_id=?2 and price between ?3 and ?4",nativeQuery = true)
    List<ProductEntity> findProductByBrandAndModeldAndPriceBetween(Integer brand_id, Integer model_id, BigDecimal min, BigDecimal max);
}

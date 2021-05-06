package az.company.turbo.repository;


import az.company.turbo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select p.* from turbo.product p join turbo.model m " +
            "on(p.model_id=m.id)" +
            "where m.brand_id=?1", nativeQuery = true)
    List<ProductEntity> findAllModelByBrandId(Integer id);
}

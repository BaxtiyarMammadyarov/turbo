package az.company.turbo.repository;



import az.company.turbo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> , JpaSpecificationExecutor<ProductEntity> {


    @Transactional
    @Query(value = "select *" +
            " from turbo.product p " +
            " join turbo.brand b on (p.brand_id = b.id)" +
            " join turbo.model m on (p.model_id = m.id)" +
            " join turbo.fuel_type ft on (p.fuel_id = ft.id)" +
            " join turbo.contact_info c on (p.contact_id = c.id)" +
            " join turbo.city ct on (c.city_id = ct.id)" +
            " WHERE CONCAT(' ',b.name) LIKE %:brandname%" +
            " and CONCAT(' ',m.name) LIKE %:modelname% " +
            " and CONCAT(' ',ct.city_name) LIKE %:cityname%" +
            " and p.price>:minprice and p.price<:maxprice and p.release_date>:mindate and p.release_date<:maxdate ", nativeQuery = true)
    List<ProductEntity> getProduct(@Param("brandname") String brandname,@Param("modelname") String modelname ,@Param("cityname") String cityname,@Param("minprice")BigDecimal minprice, @Param("maxprice")BigDecimal maxprice,@Param("mindate") Short mindate, @Param("maxdate")Short maxdate);




}
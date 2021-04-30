package az.company.turbo.repository;


import az.company.turbo.entity.BrandEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<BrandEntity, Integer> {

    boolean existsByName(String name);
     void deleteById(Integer id);
     @Query(value = "update brand set brand.name=?2 where brand.id=?1",nativeQuery = true)
     void update(int id,String name);
}

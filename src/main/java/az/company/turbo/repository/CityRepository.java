package az.company.turbo.repository;

import az.company.turbo.entity.CityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {
    boolean existsByName(String name);

    @Query(value = "update city  set city_name=?2 where id=?1", nativeQuery = true)
    void update(int id, String name);
}

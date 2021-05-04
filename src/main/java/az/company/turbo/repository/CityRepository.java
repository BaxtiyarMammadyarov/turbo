package az.company.turbo.repository;

import az.company.turbo.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    boolean existsByName(String name);

    @Query(value = "update city  set city_name=?2 where id=?1", nativeQuery = true)
    void update(int id, String name);

    String findByName(String name);
}

package az.company.turbo.repository;


import az.company.turbo.entity.CarBrend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarBrendRepository extends CrudRepository<CarBrend, Integer> {

    boolean existsByName(String name);

    @Query(value = "select id,name from car_brend ", nativeQuery = true)
    List<CarBrend> allCarBrend();

    @Query(value = "update car_brend set car_brend.name=?2 where car_brend.id=?1", nativeQuery = true)
    void updateCarBrend(int id, String name);

    void deleteByName(String name);
}

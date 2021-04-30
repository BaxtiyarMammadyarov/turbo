package az.company.turbo.repository;


import az.company.turbo.entity.ModelEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<ModelEntity, Integer> {
    boolean existsByName(String name);



    @Query(value = "update car_model set car_model.name=?2 where car_model.id=?1", nativeQuery = true)
    void update(int id, String name);

    @Query(value = "select id,name from car_model ", nativeQuery = true)
    List<ModelEntity> getAll();


}

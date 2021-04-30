package az.company.turbo.repository;

import az.company.turbo.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityEntity,Integer> {
}

package az.company.turbo.repository;

import az.company.turbo.entity.FuelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity,Integer> {
    FuelTypeEntity findByName(String name);
}

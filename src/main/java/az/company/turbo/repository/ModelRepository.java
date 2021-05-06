package az.company.turbo.repository;


import az.company.turbo.entity.ModelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {

    Optional<ModelEntity> findByName(String name);
}




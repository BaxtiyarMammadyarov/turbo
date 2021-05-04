package az.company.turbo.repository;


import az.company.turbo.entity.ModelEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
}




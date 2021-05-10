package az.company.turbo.repository;


import az.company.turbo.entity.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {





   Optional<BrandEntity> findByName(String name);
}

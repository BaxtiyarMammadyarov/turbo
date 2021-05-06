package az.company.turbo.repository;


import az.company.turbo.entity.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {





    BrandEntity findByName(String name);
}

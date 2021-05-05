package az.company.turbo.repository;

import az.company.turbo.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity,Integer> {
}

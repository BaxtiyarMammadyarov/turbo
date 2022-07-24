package az.company.turbo.repository;

import az.company.turbo.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity,Integer> {
    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);
}

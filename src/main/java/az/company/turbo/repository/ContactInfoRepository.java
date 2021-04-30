package az.company.turbo.repository;

import az.company.turbo.entity.ContactInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactInfoRepository extends CrudRepository<ContactInfoEntity,Integer> {
}

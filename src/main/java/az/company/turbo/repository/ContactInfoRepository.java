package az.company.turbo.repository;

import az.company.turbo.entity.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface ContactInfoRepository extends CrudRepository<ContactInfo,Integer> {
}

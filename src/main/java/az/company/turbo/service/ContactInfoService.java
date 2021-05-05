package az.company.turbo.service;

import az.company.turbo.dto.ContactInfoDto;
import org.springframework.stereotype.Service;


@Service
public interface ContactInfoService extends CrudService<ContactInfoDto,Integer> {
}

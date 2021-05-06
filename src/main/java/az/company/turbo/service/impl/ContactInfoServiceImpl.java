package az.company.turbo.service.impl;

import az.company.turbo.dto.CityDto;
import az.company.turbo.dto.ContactInfoDto;
import az.company.turbo.entity.CityEntity;
import az.company.turbo.entity.ContactInfoEntity;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.repository.CityRepository;
import az.company.turbo.repository.ContactInfoRepository;
import az.company.turbo.service.ContactInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactRepo;
    private final CityRepository cityRepo;

    public ContactInfoServiceImpl(ContactInfoRepository contactRepo, CityRepository cityRepo) {
        this.contactRepo = contactRepo;
        this.cityRepo = cityRepo;
    }

    public ResponseEntity<?> create(ContactInfoDto contact) {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity = copyFromDtoToEntity(contact, entity);
        entity = contactRepo.save(entity);
        contact = convertFromEntityToDto(entity);
        return ResponseEntity.ok(contact);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        ContactInfoEntity entity = getbById(id);
        contactRepo.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(ContactInfoDto contact) {
        ContactInfoEntity entity = getbById(contact.getId());
        entity = copyFromDtoToEntity(contact, entity);
        entity = contactRepo.save(entity);
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity<?> get() {
        List<ContactInfoDto> contact = contactRepo
                .findAll()
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contact);
    }

    ContactInfoDto convertFromEntityToDto(ContactInfoEntity entity) {
        return new ContactInfoDto(
                entity.getId()
                , entity.getName()
                , entity.getEmail()
                , entity.getPhone()
                , new CityDto(entity
                .getCityEntity().getId()
                , entity.getCityEntity().getName())
        );
    }

    private ContactInfoEntity getbById(Integer id) {
        return contactRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("contact id not founded."));
    }

    private CityEntity checkCity(CityDto dto) {
        return cityRepo
                .findById(dto
                        .getId())
                .orElseGet(() -> {
                    CityEntity cityEntity = new CityEntity();
                    cityEntity.setName(dto.getName());
                    cityEntity = cityRepo.save(cityEntity);
                    return cityEntity;
                });
    }

    private ContactInfoEntity copyFromDtoToEntity(ContactInfoDto dto, ContactInfoEntity entity) {
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        CityEntity city = checkCity(dto.getCity());
        entity.setCityEntity(city);
        return entity;

    }
}


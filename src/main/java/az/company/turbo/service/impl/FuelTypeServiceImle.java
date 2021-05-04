package az.company.turbo.service.impl;


import az.company.turbo.dto.FuelTypeDto;
import az.company.turbo.entity.FuelTypeEntity;
import az.company.turbo.repository.FuelTypeRepository;
import az.company.turbo.service.FuelTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuelTypeServiceImle implements FuelTypeService {
    private final FuelTypeRepository fuelTypeRepository;

    public FuelTypeServiceImle(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public ResponseEntity<?> create(FuelTypeDto fuelTypeDto) {
        FuelTypeEntity fuelTypeEntity = new FuelTypeEntity();
        fuelTypeEntity.setName(fuelTypeDto.getName());
        fuelTypeEntity = fuelTypeRepository.save(fuelTypeEntity);
        fuelTypeDto = convertFromEntityToDto(fuelTypeEntity);
        return ResponseEntity.ok(fuelTypeDto);

    }

    @Override
    public ResponseEntity<?> delete(Integer integer) {
        FuelTypeEntity entity = getById(integer);
        fuelTypeRepository.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", integer));

    }

    @Override
    public ResponseEntity<?> update(FuelTypeDto fuelTypeDto) {
        FuelTypeEntity fuelTypeEntity = getById(fuelTypeDto.getId());
        fuelTypeEntity.setName(fuelTypeDto.getName());
        fuelTypeDto = convertFromEntityToDto(fuelTypeEntity);
        return ResponseEntity.ok(fuelTypeDto);

    }

    @Override
    public ResponseEntity<?> get() {
        List<FuelTypeDto> dtoList = fuelTypeRepository
                .findAll().stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    private FuelTypeDto convertFromEntityToDto(FuelTypeEntity entity) {
        return new FuelTypeDto(entity.getId(), entity.getName());
    }

    private FuelTypeEntity getById(Integer id) {
        return fuelTypeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Brand id not founded."));
    }
}

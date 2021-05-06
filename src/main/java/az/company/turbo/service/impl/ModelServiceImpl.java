package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.repository.ModelRepository;
import az.company.turbo.service.ModelService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public ResponseEntity<?> create(ModelDto modelDto) {
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(modelDto.getName());
        BrandEntity brand = checkBrandByModel(modelDto);
        modelEntity.setBrandEntity(brand);
        modelEntity = modelRepository.save(modelEntity);
        modelDto = convertFromEntityToDto(modelEntity);
        return ResponseEntity.ok(modelDto);

    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        ModelEntity entity = getById(id);
        modelRepository.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(ModelDto modelDto) {
        ModelEntity entity = getById(modelDto.getId());
        entity.setName(modelDto.getName());
        BrandEntity brand = checkBrandByModel(modelDto);
        entity.setBrandEntity(brand);
        entity = modelRepository.save(entity);
        modelDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(modelDto);

    }

    @Override
    public ResponseEntity<?> get() {
        List<ModelDto> dtoList = modelRepository
                .findAll()
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    ModelDto convertFromEntityToDto(ModelEntity entity) {
        return new ModelDto(entity.getId(), entity.getName(), new BrandDto(entity.getBrandEntity().getId(), entity.getName()));
    }

    private ModelEntity getById(Integer id) {
        return modelRepository.findById(id).orElseThrow(() -> new RuntimeException("model id not founded."));
    }

    BrandEntity checkBrandByModel(ModelDto modelDto) {
        return brandRepository
                .findById(modelDto
                        .getBrandDto()
                        .getId())
                .orElseGet(() -> {
                    BrandEntity entity1 = new BrandEntity();
                    entity1.setName(modelDto.getBrandDto().getName());
                    entity1 = brandRepository.save(entity1);
                    return entity1;
                });
    }
}

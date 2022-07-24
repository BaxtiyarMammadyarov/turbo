package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.exception.BrandNameAlreadyExistsException;
import az.company.turbo.exception.NotFoundException;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    private final BrandRepository brandRepository;

    @Override

    public ResponseEntity<?> create(BrandDto brandDto) {
        if(brandRepository.existsByName(brandDto.getName())){
            throw new BrandNameAlreadyExistsException("Brand Name Already Exists");
        }
        BrandEntity entity = new BrandEntity();
        entity.setName(brandDto.getName());
        entity = brandRepository.save(entity);
        brandDto = convertFromEntityToDto(entity);
        return ResponseEntity.ok(brandDto);
    }


    public ResponseEntity<String> delete(Integer id) {
        BrandEntity entity = getById(id);
        brandRepository.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(BrandDto brandDto) {
        BrandEntity brand = getById(brandDto.getId());
        brand.setName(brandDto.getName());
        brand = brandRepository.save(brand);
        brandDto = convertFromEntityToDto(brand);
        return ResponseEntity.ok(brandDto);
    }

    @Override
    public ResponseEntity<?> get() {
        List<BrandDto> dtoList = brandRepository.findAll().stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);

    }

    private BrandDto convertFromEntityToDto(BrandEntity entity) {
        return new BrandDto(entity.getId(), entity.getName());
    }

    private BrandEntity getById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand id not founded."));
    }
}

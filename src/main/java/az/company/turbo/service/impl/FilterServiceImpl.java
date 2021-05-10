package az.company.turbo.service.impl;

import az.company.turbo.dto.*;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.entity.ProductEntity;
import az.company.turbo.repository.*;
import az.company.turbo.service.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final ContactInfoRepository contactInfoRepository;

    public FilterServiceImpl
            (
                    ProductRepository productRepository
                    , BrandRepository brandRepository
                    , ModelRepository modelRepository
                    , CityRepository cityRepository
                    , FuelTypeRepository fuelTypeRepository
                    , ContactInfoRepository contactInfoRepository
            ) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.cityRepository = cityRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.contactInfoRepository = contactInfoRepository;
    }


    @Override
    public ResponseEntity<?> findProductByBrandName(String name) {
        BrandEntity brand = brandRepository
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Brand name not found"));

        List<ProductDto> list = productRepository
                .findProductByBrandId(brand.getId())
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> findProductByModelId(Integer id) {
        List<ProductDto> list = productRepository
                .findProductByModelId(id)
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> findProductByModelName(String name) {
        ModelEntity model = modelRepository.findByName(name).orElseThrow(() -> new RuntimeException("Model name not found."));
        List<ProductDto> list = productRepository.findProductByModelId(model.getId()).stream().map(this::convertFromEntityToDto).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> findProductByPriceBetween(BigDecimal num1, BigDecimal num2) {
        List<ProductDto> list = productRepository
                .findPoductByPriceBetween(num1, num2)
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> findProductByModelNameAndPriceBetween(String name, BigDecimal min, BigDecimal max) {
         List<ProductDto>list=productRepository.findProductByModelNameAndPriceBetween( name, min, max)
                 .stream()
                 .map(this::convertFromEntityToDto)
                 .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    private ProductDto convertFromEntityToDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());

        dto.setModeldto(new ModelDto(entity.getModel().getId()
                , entity.getModel().getName()
                , new BrandDto(entity.getModel().getBrandEntity().getId()
                , entity.getModel().getBrandEntity().getName())));

        dto.setContactInfoDto(new ContactInfoDto(entity.getContactInfo().getId()
                , entity.getContactInfo().getName()
                , entity.getContactInfo().getEmail()
                , entity.getContactInfo().getPhone()
                , new CityDto(entity.getContactInfo().getCityEntity().getId(),
                entity.getContactInfo().getCityEntity().getName())));

        dto.setFuelType(new FuelTypeDto(entity.getFuelType().getId(), entity.getFuelType().getName()));
        dto.setEnginePower(entity.getEnginePower());
        dto.setDrive(entity.getDrive());
        dto.setDesc(entity.getDescription());
        dto.setBarter(entity.isBarterStatus());
        dto.setCreditStatus(entity.isCreditStatus());
        dto.setMileage(entity.getMileage());
        dto.setReleaseDate(entity.getReleaseDate());
        dto.setValyuta(entity.getValyuta());
        dto.setPhoto(entity.getPhoto());
        dto.setPrice(entity.getPrice());
        dto.setTransmission(entity.getTransmission());
        dto.setColor(entity.getColor());
        dto.setBodyType(entity.getBodyType());
        dto.setEngineCapacity(entity.getEngineCapacity());
        return dto;
    }
}


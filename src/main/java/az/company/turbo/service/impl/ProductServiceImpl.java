package az.company.turbo.service.impl;

import az.company.turbo.dto.ProductDto;
import az.company.turbo.entity.*;
import az.company.turbo.repository.*;
import az.company.turbo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final CityRepository cityRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final ContactInfoRepository contactInfoRepository;

    public ProductServiceImpl
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
    public ResponseEntity<?> create(ProductDto productDto) {
    return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        ProductEntity entity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product id not founded."));
        productRepository.delete(entity);
        return ResponseEntity.ok(String.format("Raw with %s id successfully deleted.", id));
    }

    @Override
    public ResponseEntity<?> update(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> get() {

        return null;
    }

    private ProductDto convertFromEntityToDto(ProductEntity entity) {
//        return new ProductDto(entity.getId()
//                , entity.getBrand()
//                , entity.getModel()
//                , entity.getFuelType()
//                ,entity.getContactInfo()
//                , entity.getDescription()
//                , entity.getDrive()
//                , entity.getEnginePower()
//                , entity.getMileage()
//                , entity.getValyuta()
//                , entity.getReleaseDate()
//                , entity.getPhoto()
//                ,entity.getBarterStatus();
//        );
    return  null;}
}

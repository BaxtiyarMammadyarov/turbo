package az.company.turbo.service.impl;


import az.company.turbo.dto.*;
import az.company.turbo.entity.*;
import az.company.turbo.repository.*;
import az.company.turbo.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {
    private static final Logger log = LoggerFactory.getLogger(FilterServiceImpl.class);
    private final ProductRepository productRepository;


    public FilterServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> getProduct(String brandName, String modelName, BigDecimal minPrice, BigDecimal maxPrice, Short minDate, Short maxDate, String cityName) {
        log.info("Starter getProduct");
        List<ProductDto> list = productRepository
                .getProduct(brandName, modelName, cityName, minPrice, maxPrice, minDate, maxDate)
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());
        log.info("ended getProduct");
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> search(SearchDto dto) {
        List<ProductDto>dtoList=productRepository
                .getProduct(
                        dto.getBrandName()
                        ,dto.getModelName()
                        ,dto.getCityName()
                        ,dto.getMinPrice()
                        ,dto.getMaxPrice()
                        ,dto.getMinReleaseDate()
                        ,dto.getMaxReleaseDate())
                .stream()
                .map(this::convertFromEntityToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }


    private ProductDto convertFromEntityToDto(ProductEntity entity) {
        log.info(" starter convertFromEntityToDto");
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setBrandDto(new BrandDto(entity.getBrandEntity().getId(), entity.getBrandEntity().getName()));
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
        log.info(" ended convertFromEntityToDto");
        return dto;
    }
//
//    private String isNotNull(String brandname, String modelname, String cityname) {
//        log.info(" starter isNotNull ");
//        String keyword = " ";
//        if (brandname != null) keyword += brandname;
//        if (modelname != null) keyword += " " + modelname;
//        if (cityname != null) keyword += " " + cityname;
//        log.info(" ended isNotNull ");
//        return keyword;
//    }

//    private BigDecimal maxPrice(BigDecimal maxprice) {
//        if (maxprice != null) return maxprice;
//        else return BigDecimal.valueOf(Double.MAX_VALUE);
//
//    }
//
//    private BigDecimal minPrice(BigDecimal minprice) {
//        if (minprice != null) return minprice;
//        else return BigDecimal.valueOf(0.0);
//    }
//
//    private Short maxDate(Short date) {
//        if (date != null) return date;
//        else return Short.MAX_VALUE;
//    }
//
//    private Short minDate(Short date) {
//        if (date != null) return date;
//        else return 0;
//    }


}


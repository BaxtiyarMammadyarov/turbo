package az.company.turbo.service;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.CityDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.dto.ProductDto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface FilterService {

    ResponseEntity<List<ProductDto>> findAll(BrandDto brand);

    ResponseEntity<List<ProductDto>> findAll(ModelDto model);

    ResponseEntity<List<ProductDto>> findAll(Short releaseDateMin,Short releaseDateMax);

 //  ResponseEntity<List<ProductDto>> findAll(BigDecimal min, BigDecimal max);

    ResponseEntity<List<ProductDto>> findAll(CityDto city);

    ResponseEntity<List<ProductDto>> findAll(boolean creditStatus);

    ResponseEntity<List<ProductDto>> findAll
            (BrandDto brand
                    , ModelDto model
                    ,Short minDate
                    , Short maxDate
                    , CityDto city
                    , boolean creditStatus
            );

//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, ModelDto model);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, ModelDto model, Short releaseDate, BigDecimal min, BigDecimal max);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, ModelDto model,  BigDecimal min, BigDecimal max);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, ModelDto model, BigDecimal min, BigDecimal max,CityDto city);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand,  Short releaseDate, BigDecimal min, BigDecimal max);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, BigDecimal min, BigDecimal max);
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, ModelDto model, Short releaseDate, BigDecimal min, BigDecimal max,boolean creditStatus );
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand, Short releaseDate, BigDecimal min, BigDecimal max,boolean creditStatus );
//    ResponseEntity<List<ProductDto>> findAll(BrandDto brand,  BigDecimal min, BigDecimal max,boolean creditStatus );

    ResponseEntity<?> findByBarterStatus();

}

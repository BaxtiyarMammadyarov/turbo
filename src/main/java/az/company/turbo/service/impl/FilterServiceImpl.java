package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.CityDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.dto.ProductDto;
import az.company.turbo.entity.ProductEntity;
import az.company.turbo.repository.ProductRepository;
import az.company.turbo.service.FilterService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FilterServiceImpl implements FilterService {
    private final ProductRepository productRepository;

    public FilterServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll(BrandDto brand) {
        List<ProductDto> list = new ArrayList<>();
        try {
            for (ProductEntity product : productRepository.findAllByBrandId(brand.getId())) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                list.add(productDto);
            }
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll(ModelDto model) {
        List<ProductDto> list = new ArrayList<>();
        try {
            for (ProductEntity product : productRepository.findAllByBrandIdAndModelId(model.getBrandDto().getId(), model.getId())) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                list.add(productDto);
            }
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll(Short dateMin, Short dateMax) {
        List<ProductDto> list = new ArrayList<>();
        try {
            for (ProductEntity product : productRepository.findAllByReleaseDateBetween(dateMin, dateMax)) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                list.add(productDto);
            }
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }

    }

//    @Override
//    public ResponseEntity<List<ProductDto>> findAll(BigDecimal min, BigDecimal max) {
//
//        List<ProductDto> list=new ArrayList<>();
//        if(productRepository.existsByPriceBetween(min,max)){
//            for(ProductEntity product:productRepository.findAllByPirceBetween(min,max)){
//                ProductDto productDto=new ProductDto();
//                BeanUtils.copyProperties(product,productDto);
//                list.add(productDto);
//            }
//            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
//        }else  return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
//    }

//    @Override
//    public ResponseEntity<List<ProductDto>> findAll(CityDto city) {
//        List<ProductDto> list=new ArrayList<>();
//        try{
//            for(ProductEntity product:productRepository.findAllByCity(city.getName())){
//                ProductDto productDto=new ProductDto();
//                BeanUtils.copyProperties(product,productDto);
//                list.add(productDto);
//            }
//            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
//        }
//
//    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll(boolean creditStatus) {
        List<ProductDto> list = new ArrayList<>();
        try {
            for (ProductEntity product : productRepository.findAllByCreditStatus(creditStatus)) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                list.add(productDto);
            }
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<?> findByBarterStatus() {
        return null;
    }
}

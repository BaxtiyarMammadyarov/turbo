package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.CityDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.dto.ProductDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.entity.ProductEntity;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.repository.ModelRepository;
import az.company.turbo.repository.ProductRepository;
import az.company.turbo.service.FilterService;
import az.company.turbo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {
    private final ProductRepository productRepository;

    public FilterServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> findAllByBrand(Integer id) {


        return null;
    }


}

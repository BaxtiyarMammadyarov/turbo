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
}

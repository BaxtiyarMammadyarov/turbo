package az.company.turbo.service.impl;

import az.company.turbo.dto.ProductDto;
import az.company.turbo.entity.*;
import az.company.turbo.repository.ProductRepository;
import az.company.turbo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
}

    @Override
    public ResponseEntity<?> create(ProductDto productDto) {
        ProductEntity product=new ProductEntity();
        BeanUtils.copyProperties(productDto,product);
        productRepository.save(product);
        return new ResponseEntity<>("created", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> get() {
        return null;
    }
}

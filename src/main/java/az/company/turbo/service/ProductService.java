package az.company.turbo.service;

import az.company.turbo.dto.ProductDto;


import org.springframework.stereotype.Service;

@Service
public interface ProductService extends CrudService<ProductDto,Long> {
}

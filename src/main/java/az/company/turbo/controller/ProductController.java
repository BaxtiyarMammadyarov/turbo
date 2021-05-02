package az.company.turbo.controller;

import az.company.turbo.dto.ProductDto;
import az.company.turbo.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(description = "Actions on product")
public class ProductController {
    private final ProductService  productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<?>create(@RequestBody ProductDto product){
    return     productService.create(product);
    }
}

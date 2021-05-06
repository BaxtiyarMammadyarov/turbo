package az.company.turbo.controller;

import az.company.turbo.dto.ProductDto;
import az.company.turbo.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(description = "Actions on product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return productService.get();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDto product) {
        return productService.create(product);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return productService.delete(id);
    }

}

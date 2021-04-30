package az.company.turbo.controller;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.service.BrandSerice;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brand")
@Api(description = "Actions on Brand")
public class BrandController {
    private final BrandSerice brandSerice;

    public BrandController(BrandSerice brandSerice) {
        this.brandSerice = brandSerice;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDto brandDto) {
        return brandSerice.create(brandDto);
    }

    @GetMapping
    public ResponseEntity get() {
        return brandSerice.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return brandSerice.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BrandDto brandDto) {
        return brandSerice.update(brandDto);
    }
}

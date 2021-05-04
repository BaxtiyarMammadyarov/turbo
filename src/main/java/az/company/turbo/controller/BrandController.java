package az.company.turbo.controller;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/brand")
@Api(description = "Actions on Brand")
public class BrandController {
    private final BrandService brandService;
    public BrandController(BrandService brandSerice) {
        this.brandService = brandSerice;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody BrandDto brandDto) {
        return (ResponseEntity<String>) brandService.create(brandDto);
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> get() {
        return (ResponseEntity<List<BrandDto>>) brandService.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return (ResponseEntity<String>) brandService.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody BrandDto brandDto) {
        return (ResponseEntity<String>) brandService.update(brandDto);
    }
}

package az.company.turbo.controller;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.service.BrandSerice;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brand")
@Api(description = "Actions on Brand")
public class BrandController {
    private final BrandSerice brandSerice;

    public BrandController(BrandSerice brandSerice) {
        this.brandSerice = brandSerice;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody BrandDto brandDto) {
        return (ResponseEntity<String>) brandSerice.create(brandDto);
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> get() {
        return (ResponseEntity<List<BrandDto>>) brandSerice.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return (ResponseEntity<String>) brandSerice.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody BrandDto brandDto) {
        return (ResponseEntity<String>) brandSerice.update(brandDto);
    }
}

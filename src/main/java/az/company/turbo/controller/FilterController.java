package az.company.turbo.controller;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.CityDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.service.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/Filter")
public class FilterController {
    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping("/brand")
    public ResponseEntity<?> get(@RequestBody BrandDto brand) {
        return filterService.findAll(brand);
    }

    @GetMapping("/model")
    public ResponseEntity<?> get(@RequestBody ModelDto model) {
        return filterService.findAll(model);
    }

    @GetMapping("/releaseDate/{min},{max}")
    public ResponseEntity<?> get(@PathVariable("min") Short releaseDateMin, @PathVariable("max") Short releaseDateMax) {
        return filterService.findAll(releaseDateMin, releaseDateMax);
    }

//    @GetMapping("/price/{min},{max}")
//    public ResponseEntity<?> get(@PathVariable("min") BigDecimal min, @PathVariable("max") BigDecimal max) {
//        return filterService.findAll(min, max);
//    }

    @GetMapping("/creditstatus")
    public ResponseEntity<?> get(@PathVariable boolean creditStatus) {
        return filterService.findAll(creditStatus);
    }

//    @GetMapping("/city")
//    public ResponseEntity<?> get(@RequestBody CityDto city) {
//        return filterService.findAll(city);
//    }


}

package az.company.turbo.controller;

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


    @GetMapping("/search")
    public ResponseEntity<?> getSearch(
            @RequestParam (defaultValue =" ")String brandName,
            @RequestParam(defaultValue =" ") String modelName,
            @RequestParam (defaultValue =""+Double.MIN_VALUE)BigDecimal minPrice,
            @RequestParam(defaultValue =""+Double.MAX_VALUE) BigDecimal maxPrice,
            @RequestParam(defaultValue =""+Short.MIN_VALUE) Short minDate ,
            @RequestParam (defaultValue =""+Short.MAX_VALUE)Short maxDate,
            @RequestParam(defaultValue =" ") String cityName ) {
        return filterService.getProduct(brandName,modelName,minPrice,maxPrice,minDate,maxDate,cityName);
    }





}

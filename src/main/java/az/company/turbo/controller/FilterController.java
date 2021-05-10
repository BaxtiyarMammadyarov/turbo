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

    @GetMapping("/{model_id}")
    public ResponseEntity<?> getByModelId(@PathVariable("model_id") Integer id) {
        return filterService.findProductByModelId(id);
    }

    @GetMapping("/{model_name}")
    public ResponseEntity<?> getByModelName(@PathVariable("model_name") String name) {
        return filterService.findProductByModelName(name);
    }

    @GetMapping("/{brand_name}")
    public ResponseEntity<?> getByBrandName(@PathVariable("brand_name") String name) {
        return filterService.findProductByBrandName(name);
    }

    @GetMapping("/price")
    public ResponseEntity<?> getByPriceBetween(@RequestParam("min") BigDecimal min, @RequestParam("max") BigDecimal max) {
        return filterService.findProductByPriceBetween(min, max);
    }
    @GetMapping("/model_and_price")
    public ResponseEntity<?> getByModelPriceBetween(@RequestParam("name")String name,@RequestParam("min") BigDecimal min, @RequestParam("max") BigDecimal max) {
        return filterService.findProductByModelNameAndPriceBetween(name,min,max);
    }
}

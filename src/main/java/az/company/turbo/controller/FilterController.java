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


    @GetMapping("/model/{model_name}")
    public ResponseEntity<?> getByModelName(@PathVariable("model_name") String name) {
        return filterService.findProductByModelName(name);
    }

    @GetMapping("/brand/{brand_name}")
    public ResponseEntity<?> getByBrandName(@PathVariable("brand_name") String name) {
        return filterService.findProductByBrandName(name);
    }

    @GetMapping("/price/price_between")
    public ResponseEntity<?> getByPriceBetween(@RequestParam("min") BigDecimal min, @RequestParam("max") BigDecimal max) {
        return filterService.findProductByPriceBetween(min, max);
    }

    @GetMapping("/model_and_price/model_and_pricebetween")
    public ResponseEntity<?> getByModelPriceBetween(@RequestParam("name") String name, @RequestParam("min") BigDecimal min, @RequestParam("max") BigDecimal max) {
        return filterService.findProductByModelNameAndPriceBetween(name, min, max);
    }
    @GetMapping("/brandname_modelname_And_PriceBetween/{brand}/{model}/{min}/{max}")
   public ResponseEntity<?>getProductByBrandNameModelNameAndPriceBetween(
           @PathVariable("brand") String brandname
            ,@PathVariable("model")String modelname
            ,@PathVariable("min")BigDecimal min
            ,@PathVariable("max")BigDecimal max){
        return  filterService.findProductByBrandNameAndModelNameAndPriceBetween(brandname,modelname,min,max);
    };



}

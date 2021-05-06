package az.company.turbo.controller;

import az.company.turbo.service.FilterService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Filter")
public class FilterController {
    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByBrend(@PathVariable Integer id) {
        return filterService.findAllByBrand(id);
    }
}

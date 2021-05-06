package az.company.turbo.controller;

import az.company.turbo.dto.CityDto;
import az.company.turbo.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@Api(description = "Actions on City")
public class CityController {
    private final CityService service;

    public CityController(CityService cityService) {
        this.service = cityService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CityDto city) {
        return (ResponseEntity<String>) service.create(city);
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> get() {
        return (ResponseEntity<List<CityDto>>) service.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return (ResponseEntity<String>) service.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CityDto city) {
        return (ResponseEntity<String>) service.update(city);
    }


}

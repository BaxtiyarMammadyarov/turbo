package az.company.turbo.controller;


import az.company.turbo.dto.ModelDto;
import az.company.turbo.service.ModelService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@Api(description = "Actions on model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ModelDto modelDto) {
        return (ResponseEntity<String>) modelService.create(modelDto);
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> get() {
        return (ResponseEntity<List<ModelDto>>) modelService.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return (ResponseEntity<String>) modelService.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ModelDto modelDto) {
        return (ResponseEntity<String>) modelService.update(modelDto);
    }
}

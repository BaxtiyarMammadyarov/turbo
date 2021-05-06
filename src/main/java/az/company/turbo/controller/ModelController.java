package az.company.turbo.controller;


import az.company.turbo.dto.ModelDto;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.service.ModelService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
@Api(description = "Actions on model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDto modelDto) {
        return modelService.create(modelDto);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return modelService.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return modelService.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ModelDto modelDto) {
        return modelService.update(modelDto);
    }
}

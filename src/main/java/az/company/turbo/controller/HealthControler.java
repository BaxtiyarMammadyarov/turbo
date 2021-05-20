package az.company.turbo.controller;

import az.company.turbo.service.HealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthControler {
  private final HealthService service;

    public HealthControler(HealthService service) {
        this.service = service;
    }

    @GetMapping("/person")
    public ResponseEntity<?>getPerson(){
        return service.get();
    }

    @GetMapping("/District")
    public ResponseEntity<?>getDistricts(){
        return service.getDistricts();
    }
}

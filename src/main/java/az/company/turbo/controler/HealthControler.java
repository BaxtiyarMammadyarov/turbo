package az.company.turbo.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthControler {
    @GetMapping("/control")
    public ResponseEntity<?>health(){
        return ResponseEntity.ok().body("ok");
    }


}

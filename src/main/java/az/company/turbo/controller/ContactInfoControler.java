package az.company.turbo.controller;


import az.company.turbo.dto.ContactInfoDto;
import az.company.turbo.service.ContactInfoService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/contactinfo")
@Api(description = "Actions on ContactInfo")
public class ContactInfoControler {
    private final ContactInfoService infoService;

    public ContactInfoControler(ContactInfoService infoService) {
        this.infoService = infoService;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContactInfoDto dto) {
        return infoService.create(dto);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return  infoService.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return infoService.delete(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ContactInfoDto dto) {
        return infoService.update(dto);
    }

}

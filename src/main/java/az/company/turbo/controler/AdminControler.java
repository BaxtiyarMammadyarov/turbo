package az.company.turbo.controler;

import az.company.turbo.dto.CarBrendDto;
import az.company.turbo.dto.CarModelDto;
import az.company.turbo.util.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping("/admin")
public class AdminControler {
    @Autowired
    private AdminService adminService;


    @PostMapping("/addCarBrend")
    public String addtCarBrend(@RequestBody CarBrendDto carBrendDto) {
        return adminService.addtCarBrend(carBrendDto);
    }

    @GetMapping("/allCarBrend")
    public List<CarBrendDto> allCarBrend() {
        return adminService.allCarBrend();
    }

    @DeleteMapping("/deleteCarBrend/{id}")
    public void deleteCarBrend(@PathVariable int id) {
        adminService.deleteCarBrend(id);
    }

    @DeleteMapping("/deleteCarBrend/{name}")
    public void deleteCarBrend(@PathVariable String name) {
        adminService.deleteCarBrend(name);
    }

    @PatchMapping("/update/{id},{name}")
    public void updateCarBrend(@PathVariable("id") int id, @PathVariable("name") String name) {
        adminService.updateCarBrend(id, name);
    }

     public void addCarModel(CarModelDto carModelDto){
        adminService.addCarModel(carModelDto);
     }
}

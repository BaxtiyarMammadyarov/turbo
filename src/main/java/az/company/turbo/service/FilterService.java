package az.company.turbo.service;


import az.company.turbo.dto.BrandDto;
import az.company.turbo.entity.BrandEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public interface FilterService {

    ResponseEntity<?>findAllByBrand(Integer id);


}

package az.company.turbo.service;


import az.company.turbo.dto.SearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;


@Service
public interface FilterService {

    ResponseEntity<?> getProduct(String brandName,String modelName,
                                 BigDecimal minPrice,
                                 BigDecimal maxPrice,
                                 Short minDate,
                                 Short maxDate,
                                 String cityName );

    ResponseEntity<?>search(SearchDto dto);


}

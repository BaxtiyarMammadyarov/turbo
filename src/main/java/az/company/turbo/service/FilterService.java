package az.company.turbo.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public interface FilterService {

  ResponseEntity<?>findProductByBrandName(String name);
  ResponseEntity<?> findProductByModelName(String name);
  ResponseEntity<?>findProductByPriceBetween(BigDecimal num1,BigDecimal num2);
  ResponseEntity<?>findProductByModelNameAndPriceBetween(String name,BigDecimal min,BigDecimal max);

  ResponseEntity<?> findProductByBrandNameAndModelNameAndPriceBetween(String brandname, String modelname, BigDecimal min, BigDecimal max);


}

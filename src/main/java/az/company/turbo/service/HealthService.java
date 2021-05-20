package az.company.turbo.service;

import az.company.turbo.client.DistrictResponse;
import az.company.turbo.client.ResponsePerson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HealthService {
    private final ResponsePerson responsePerson;
private final DistrictResponse districtResponse;

    public HealthService(ResponsePerson response, DistrictResponse districtResponse) {
        this.responsePerson = response;
        this.districtResponse = districtResponse;
    }

    public ResponseEntity<?> get() {
        return ResponseEntity.ok(responsePerson.getPerson());
    }
     public ResponseEntity<?> getDistricts(){
         return ResponseEntity.ok(districtResponse.get());
        }

}

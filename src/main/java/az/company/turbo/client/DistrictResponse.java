package az.company.turbo.client;

import az.company.turbo.dto.clientdto.Districts;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DistrictResponse {
    public Districts get(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Districts> entity = new HttpEntity(httpHeaders);


        String url = "https://api.opendata.az/v1/json/map/districts?pretty";


        return  restTemplate.exchange(url, HttpMethod.GET, entity,Districts.class ).getBody();
    }
}

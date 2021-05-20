package az.company.turbo.client;

import az.company.turbo.dto.clientdto.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ResponsePerson {
    private Object Person;

//    public District getDistricts() {
//        District district;
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        HttpEntity entity = new HttpEntity(httpHeaders);
//
//        String url = "https://api.opendata.az/v1/json/map/districts";
//
//        district = restTemplate.exchange(url, HttpMethod.GET, entity, District.class).getBody();
//        return district;
//    }

    public List<Person> getPerson() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Person>> entity = new HttpEntity(httpHeaders);


        String url = "http://localhost:8081/emp";


        return  restTemplate.exchange(url, HttpMethod.GET, entity, ArrayList.class).getBody();
    }
}

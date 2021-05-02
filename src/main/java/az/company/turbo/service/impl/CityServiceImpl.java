package az.company.turbo.service.impl;


import az.company.turbo.dto.CityDto;
import az.company.turbo.entity.CityEntity;
import az.company.turbo.repository.CityRepository;
import az.company.turbo.service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public ResponseEntity<String> create(CityDto cityDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "City");
        if (!cityRepository.existsByName(cityDto.getName())) {
            CityEntity city = new CityEntity();
            BeanUtils.copyProperties(cityDto, city);
            cityRepository.save(city);
            msg = "created successful";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        } else {
            msg = "this City is available in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "City");
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            msg = "deleted";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> update(CityDto cityDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "City");
        if (cityRepository.existsById(cityDto.getId())) {
            cityRepository.update(cityDto.getId(), cityDto.getName());
            msg = "updatig";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<List<CityDto>> get() {
        List<CityDto> list = new ArrayList<>();

        if (cityRepository.findAll() != null) {
            for (CityEntity city : cityRepository.findAll()) {
                CityDto cityDto = new CityDto();
                BeanUtils.copyProperties(city, cityDto);
                list.add(cityDto);
            }
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

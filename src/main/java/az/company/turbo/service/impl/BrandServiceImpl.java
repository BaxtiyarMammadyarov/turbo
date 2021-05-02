package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    private final BrandRepository brandRepository;

    @Override
    public ResponseEntity<String> create(BrandDto brandDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Brand");
        if (!brandRepository.existsByName(brandDto.getName())) {
            BrandEntity brandEntity = new BrandEntity();
            BeanUtils.copyProperties(brandDto, brandEntity);
            brandRepository.save(brandEntity);
            msg = "created successful";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        } else {
            msg = "this brand is available in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }
    }


    public ResponseEntity<String> delete(Integer id) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Brand");
        if (brandRepository.existsById(id)) {
            msg = "deleted";
            brandRepository.deleteById(id);
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> update(BrandDto brandDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Brand");
        if(brandRepository.existsById(brandDto.getId())){
            brandRepository.update(brandDto.getId(), brandDto.getName());
            msg="Update";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }else{
            msg="There is no id in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }
    }


    @Override
    public ResponseEntity<List<BrandDto>> get() {

        List<BrandDto> dtoList = new ArrayList<>();
        if(brandRepository.findAll()!=null){
        for (BrandEntity car : brandRepository.findAll()) {
            BrandDto brandDto = new BrandDto();
            BeanUtils.copyProperties(car, brandDto);
            dtoList.add(brandDto);
        }
        return new ResponseEntity<> (dtoList, HttpStatus.ACCEPTED);
    }else  return new ResponseEntity<> (HttpStatus.NOT_FOUND);

    }
}

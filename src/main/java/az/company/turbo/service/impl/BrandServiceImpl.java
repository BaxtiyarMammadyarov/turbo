package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.service.BrandSerice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandSerice {
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    private final BrandRepository brandRepository;

    @Override
    public ResponseEntity<String> create(BrandDto brandDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        if (!brandRepository.existsByName(brandDto.getName())) {
            BrandEntity brandEntity = new BrandEntity();
            brandEntity.setId(brandDto.getId());
            brandEntity.setName(brandDto.getName());
            brandRepository.save(brandEntity);
            msg = "created successful";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        } else {
            msg = "this brand is available in the database";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }
    }


    public ResponseEntity<?> delete(Integer id) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        if (brandRepository.existsById(id)) {
            msg = "deleted";
            brandRepository.deleteById(id);
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> update(BrandDto brandDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        if(brandRepository.existsById(brandDto.getId())){
            brandRepository.update(brandDto.getId(), brandDto.getName());
            msg="Update";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }else{
            msg="There is no id in the database";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }
    }


    @Override
    public ResponseEntity<List<BrandDto>> get() {
        BrandDto brandDto = new BrandDto();
        List<BrandDto> dtoList = new ArrayList<>();
        if(brandRepository.findAll()!=null){
        for (BrandEntity car : brandRepository.findAll()) {
            brandDto.setId(car.getId());
            brandDto.setName(car.getName());
            dtoList.add(brandDto);
        }
        return new ResponseEntity<List<BrandDto>> (dtoList, HttpStatus.ACCEPTED);
    }else  return new ResponseEntity<List<BrandDto>> (HttpStatus.NOT_FOUND);

    }
}

package az.company.turbo.service.impl;

import az.company.turbo.dto.BrandDto;
import az.company.turbo.dto.ModelDto;
import az.company.turbo.entity.BrandEntity;
import az.company.turbo.entity.ModelEntity;
import az.company.turbo.repository.BrandRepository;
import az.company.turbo.repository.ModelRepository;
import az.company.turbo.service.ModelService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public ResponseEntity<String> create(ModelDto modelDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Model");
        if (!modelRepository.existsByName(modelDto.getName())) {
            ModelEntity modelEntity = new ModelEntity();
            modelEntity.setName(modelDto.getName());
            if (brandRepository.existsByName(modelDto.getBrandDto().getName())) {
                modelEntity.setBrandEntity(brandRepository.findBrandEntityByName(modelDto.getBrandDto().getName()));
                modelRepository.save(modelEntity);
                msg = "created successful";
                return new ResponseEntity<>(msg, headers, HttpStatus.OK);
            } else {
                BrandEntity brandEntity = new BrandEntity();
                brandEntity.setName(modelDto.getBrandDto().getName());
                brandRepository.save(brandEntity);
                modelRepository.save(modelEntity);
                msg = "created successful";
                return new ResponseEntity<>(msg, headers, HttpStatus.OK);
            }
        } else {
            msg = "this model is available in the database";
            return new ResponseEntity<>(msg, headers, HttpStatus.OK);
        }


    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Model");
        if (modelRepository.existsById(id)) {
            modelRepository.deleteById(id);
            msg = "deleted";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<?> update(ModelDto modelDto) {
        String msg;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Model");
        if (modelRepository.existsById(modelDto.getId())) {
            modelRepository.update(modelDto.getId(), modelDto.getName());
            msg = "Update";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        } else {
            msg = "There is no id in the database";
            return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<ModelDto>> get() {
        ModelDto modelDto = new ModelDto();
        List<ModelDto> dtoList = new ArrayList<>();
        if (brandRepository.findAll() != null) {
            for (ModelEntity model : modelRepository.findAll()) {
                modelDto.setId(model.getId());
                modelDto.setName(model.getName());
                BrandDto brand = new BrandDto();
                brand.setId(model.getBrandEntity().getId());
                brand.setName(model.getBrandEntity().getName());
                modelDto.setBrandDto(brand);
                dtoList.add(modelDto);

            }
            return new ResponseEntity<List<ModelDto>>(dtoList, HttpStatus.ACCEPTED);

        } else return new ResponseEntity<List<ModelDto>>(HttpStatus.NOT_FOUND);
    }
}

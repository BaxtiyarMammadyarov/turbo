package az.company.turbo.service;

import az.company.turbo.dto.BrandDto;

import org.springframework.stereotype.Service;

@Service
public interface BrandService extends CrudService<BrandDto,Integer> {
}

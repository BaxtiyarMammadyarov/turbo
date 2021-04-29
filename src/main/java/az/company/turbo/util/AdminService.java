package az.company.turbo.util;

import az.company.turbo.dto.CarBrendDto;
import az.company.turbo.dto.CarModelDto;

import java.util.List;

public interface AdminService {
    String addtCarBrend(CarBrendDto carBrendDto);

    List<CarBrendDto> allCarBrend();

    void deleteCarBrend(int id);

    void deleteCarBrend(String name);

    void updateCarBrend(int id, String name);

    String addCarModel(CarModelDto carModelDto);

    void deleteCarModel(int id);

    void deleteCarModel(String name);

    void updateCarModel(int id, String name);
    List<CarModelDto>allCarModel();

}

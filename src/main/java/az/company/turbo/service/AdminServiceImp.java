package az.company.turbo.service;

import az.company.turbo.dto.CarBrendDto;

import az.company.turbo.dto.CarModelDto;
import az.company.turbo.entity.CarBrend;
import az.company.turbo.entity.CarModel;
import az.company.turbo.repository.CarBrendRepository;
import az.company.turbo.repository.CarModelRepository;
import az.company.turbo.util.AdminService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private CarBrendRepository carBrendRepository;
    @Autowired
    private CarModelRepository carModelRepository;

    private CarBrend carBrend;
    private CarBrendDto carBrendDto;
    private List<CarBrendDto> dtoList;
    private CarModel carModel;
    private CarModelDto carModelDto;
    private List<CarModelDto> dtoListModel;

    @Override
    public String addtCarBrend(CarBrendDto carBrendDto) {
        if (!carBrendRepository.existsByName(carBrendDto.getName())) {
            carBrend = new CarBrend();
            carBrend.setId(carBrendDto.getId());
            carBrend.setName(carBrendDto.getName());
            carBrendRepository.save(carBrend);
            return "successful";
        } else return "this brand is available in the database";
    }

    public List<CarBrendDto> allCarBrend() {
        for (CarBrend car : carBrendRepository.allCarBrend()) {
            carBrendDto.setId(car.getId());
            carBrendDto.setName(car.getName());
            dtoList.add(carBrendDto);
        }
        return dtoList;
    }

    @Override
    public void deleteCarBrend(int id) {

        carBrendRepository.deleteById(id);

    }

    @Override
    public void deleteCarBrend(String name) {
        carBrendRepository.deleteByName(name);

    }

    @Override
    public void updateCarBrend(int id, String name) {
        carBrendRepository.updateCarBrend(id, name);
    }

    @Override
    public String addCarModel(CarModelDto carModelDto) {
        if (!carModelRepository.existsByName(carModelDto.getName())) {
            carModel = new CarModel();
            carModel.setId(carModelDto.getId());
            carModel.setName(carModelDto.getName());
            carModelRepository.save(carModel);
            return "successful";
        } else return "this model is available in the database";

    }

    @Override
    public void deleteCarModel(int id) {
        carModelRepository.deleteById(id);
    }

    @Override
    public void deleteCarModel(String name) {
       carModelRepository.deleteByName(name);
    }

    @Override
    public void updateCarModel(int id, String name) {
        carModelRepository.updateCarModel(id,name);

    }

    @Override
    public List<CarModelDto> allCarModel() {
        for (CarModel model : carModelRepository.allCarModel()) {
            carModelDto.setId(model.getId());
            carModelDto.setName(model.getName());
            carModelDto.getCarBrendDto().setId(model.getCarBrend().getId());
            dtoListModel.add(carModelDto);
        }
        return dtoListModel;
    }


}

package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.CarTypeDTO;
import lk.easyrental.spring.entity.CarType;
import lk.easyrental.spring.repo.CarTypeRepo;
import lk.easyrental.spring.service.CarTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    CarTypeRepo carTypeRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCarType(CarTypeDTO dto) {

    }

    @Override
    public void updateCarType(CarTypeDTO dto) {

    }

    @Override
    public CarTypeDTO searchCarType(String id) {
        return null;
    }

    @Override
    public void deleteCarType(String id) {

    }

    @Override
    public List<CarTypeDTO> getAllCarTypes() {
        return null;
    }

    @Override
    public CarTypeDTO getCarTypeUsingName(String name) {
        CarType carType = carTypeRepo.findByName(name);

        return mapper.map(carType,CarTypeDTO.class);
    }
}

package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.CarDTO;
import lk.easyrental.spring.dto.CarTypeDTO;

import java.util.List;

public interface CarTypeService {
    void saveCarType(CarTypeDTO dto);

    void updateCarType(CarTypeDTO dto);

    CarTypeDTO searchCarType(String id);

    void deleteCarType(String id);

    List<CarTypeDTO> getAllCarTypes();

    CarTypeDTO getCarTypeUsingName(String name);
}

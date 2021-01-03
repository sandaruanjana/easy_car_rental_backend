package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.CarImageDTO;
import lk.easyrental.spring.dto.DriverImageDTO;

import java.util.List;

public interface CarImageService {
    void saveCarImage(CarImageDTO dto);

    void updateCarImage(CarImageDTO dto);

    CarImageDTO searchCarImage(String id);

    void deleteCarImage(String id);

    List<CarImageDTO> getAllCarImages();
}

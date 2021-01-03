package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.DriverDTO;
import lk.easyrental.spring.dto.DriverImageDTO;

import java.util.List;

public interface DriverImageService {
    void saveDriverImage(DriverImageDTO dto);

    void updateDriverImage(DriverImageDTO dto);

    DriverImageDTO searchDriverImage(String id);

    void deleteDriverImage(String id);

    List<DriverImageDTO> getAllDriversImages();
}

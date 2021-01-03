package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);

    void updateDriver(DriverDTO dto);

    DriverDTO searchDriver(String id);

    void deleteDriver(String id);

    List<DriverDTO> getAllDrivers();

    DriverDTO randomDriver();

    void updateDriverStatus(String id,String status);


}

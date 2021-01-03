package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.CarDTO;
import lk.easyrental.spring.dto.CustomerDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);

    void updateCar(CarDTO dto);

    CarDTO searchCar(String id);

    void deleteCar(String id);

    List<CarDTO> getAllCars();

    String seachCarTypeIdUsingBrand(String name);

    List<String> AllAvailableCars();

    void updateCarAvailable(String id);

    void updateCarAvailableUsingBookingId(String id,String status);

    CarDTO getCarDetailsUsingBrand(String brand);
}

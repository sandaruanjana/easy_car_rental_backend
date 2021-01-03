package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.CarDTO;
import lk.easyrental.spring.dto.CarTypeDTO;
import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.entity.Car;
import lk.easyrental.spring.entity.CarType;
import lk.easyrental.spring.repo.CarRepo;
import lk.easyrental.spring.repo.CarTypeRepo;
import lk.easyrental.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    CarTypeRepo carTypeRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCar(CarDTO dto) {

        Optional<CarType> carType = carTypeRepo.findById(dto.getCar_type_id());

        if (carType.isPresent()) {
            CarType carTypeData = mapper.map(carType.get(), CarType.class);

            Car data = new Car(dto.getCar_id(), dto.getBrand(), dto.getNumber_of_passengers(), dto.getTransmission_type(), dto.getFuel_type(), dto.getRegistraion_number(), dto.getColor(), dto.getMaintain_status(), dto.getDamage_status(), dto.getUsed_km(), dto.getDaily_rate(), dto.getFree_km_day(), dto.getMonthly_rate(), dto.getFree_km_month(), dto.getCost_extra_km(),dto.getAvailable(), carTypeData, null, null);

            carRepo.save(data);
        }


    }

    @Override
    public void updateCar(CarDTO dto) {

    }

    @Override
    public CarDTO searchCar(String id) {

        Optional<Car> byId = carRepo.findById(id);
        if (byId.isPresent()){
            return mapper.map(byId.get(),CarDTO.class);
        }else {
            throw new RuntimeException("Cant Find Car");
        }
    }

    @Override
    public void deleteCar(String id) {

    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public String seachCarTypeIdUsingBrand(String name) {
        String byBrand = carRepo.findByBrand(name);
        return byBrand;
    }

    @Override
    public List<String> AllAvailableCars() {
        List<String> strings = carRepo.AllAvailableCars();
        return strings;
    }

    @Override
    public void updateCarAvailable(String id) {


        if (carRepo.existsById(id)){
            carRepo.updateCarAvailable(id);
        }else {
            throw new RuntimeException("Cant Find Car");
        }


    }

    @Override
    public void updateCarAvailableUsingBookingId(String id, String status) {
        String car_id = carRepo.getCarIdFromBookingId(id);
        if (carRepo.existsById(car_id)){
            carRepo.updateCarAvailableStatusUsingCarId(status,car_id);
        }else {
            throw new RuntimeException("Car Available Update Status Fail");
        }
    }

    @Override
    public CarDTO getCarDetailsUsingBrand(String brand) {
        System.out.println(brand);
        Car carDetailsU = carRepo.getCarDetailsUsingBrand(brand);
        return mapper.map(carDetailsU,CarDTO.class);
    }


}

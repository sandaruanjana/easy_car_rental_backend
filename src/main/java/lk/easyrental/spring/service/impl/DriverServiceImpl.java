package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.DriverDTO;
import lk.easyrental.spring.entity.Driver;
import lk.easyrental.spring.entity.User;
import lk.easyrental.spring.entity.UserRole;
import lk.easyrental.spring.repo.DriverRepo;
import lk.easyrental.spring.repo.UserRepo;
import lk.easyrental.spring.repo.UserRoleRepo;
import lk.easyrental.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {

        if (dto.getRole().equalsIgnoreCase("Driver")){

            Driver driver = new Driver(dto.getDriver_id(), dto.getName(), dto.getGender(), dto.getTel(), dto.getAddress(),"Yes", new Date(), null, null);

            driverRepo.save(driver);

            UserRole ro = userRoleRepo.getUserRoleIdUsingName("driver");
            User user = new User(dto.getDriver_id(), dto.getUsername(), dto.getPassword(), ro);
            userRepo.save(user);

        }else {
            throw new RuntimeException("Driver Register Fail!");
        }

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> byId = driverRepo.findById(id);
        if (byId.isPresent()){
            return mapper.map(byId.get(),DriverDTO.class);
        }else {
            throw new RuntimeException("Driver Search Fail!");
        }

    }

    @Override
    public void deleteDriver(String id) {

        if (driverRepo.existsById(id)){
            driverRepo.deleteById(id);
            userRepo.deleteById(id);
        }else {
            throw new RuntimeException("Driver Delete Fail! Cant Find Driver");
        }


    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return null;
    }

    @Override
    public DriverDTO randomDriver() {
        Driver driver = driverRepo.randomDriver();
        return mapper.map(driver,DriverDTO.class);
    }

    @Override
    public void updateDriverStatus(String id, String status) {
        String driver_id = driverRepo.getDriverIdFromBookingId(id);

        if (driverRepo.existsById(driver_id)){
            driverRepo.updateAvailableStatus(status,driver_id);
        }else {
            throw new RuntimeException("Driver Status Update Fail!");
        }


    }




}

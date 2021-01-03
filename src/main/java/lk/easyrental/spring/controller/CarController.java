package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.CarDTO;
import lk.easyrental.spring.dto.CarImageDTO;
import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.DriverImageDTO;
import lk.easyrental.spring.service.CarImageService;
import lk.easyrental.spring.service.CarService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
@CrossOrigin
public class CarController {
    private static final String UPLOADED_FOLDER = "E:\\CarRentalResource\\Images\\Cars\\";

    @Autowired
    CarService carService;

    @Autowired
    CarImageService carImageService;

    @PostMapping
    public ResponseEntity addCar(@RequestBody CarDTO dto) {

        String id = UUID.randomUUID().toString();
        dto.setCar_id(id);

        carService.saveCar(dto);

        StandradResponse response = new StandradResponse(200, "Success", id);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{upload}")
    public ResponseEntity upload(@RequestParam("file") MultipartFile[] file, @RequestParam("id") String id) {

        for (MultipartFile files : file) {

            String fileNames = UUID.randomUUID().toString();
            String contentType = files.getContentType();
            String[] split = contentType.split("/");

            File destinationFile = new File(UPLOADED_FOLDER + fileNames + "." + split[1]);
            try {

                files.transferTo(destinationFile);

                CarImageDTO carImageDTO = new CarImageDTO(UUID.randomUUID().toString(), destinationFile.getName(), id);
                carImageService.saveCarImage(carImageDTO);


            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"brand"})
    public ResponseEntity seachCarTypeIdUsingBrand(@RequestParam String brand) {
        String carId = carService.seachCarTypeIdUsingBrand(brand);
        StandradResponse response = new StandradResponse(200, "Success", carId);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{getAllAvailableCars}")
    public ResponseEntity getAllAvailableCars() {
        List<String> strings = carService.AllAvailableCars();
        return new ResponseEntity(new StandradResponse(200, "Success", strings), HttpStatus.OK);
    }

    @GetMapping(params = {"details"})
    public ResponseEntity getCarDetailsUsingBrand(@RequestParam String details) {
        System.out.println(details);
        CarDTO carDetails = carService.getCarDetailsUsingBrand(details);
        return new ResponseEntity(new StandradResponse(200, "Success", carDetails), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCars() {
        List<CarDTO> allCars = carService.getAllCars();
        return new ResponseEntity(new StandradResponse(200, "Success", allCars), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity searchCar(String id) {
        CarDTO carDTO = carService.searchCar(id);
        return new ResponseEntity(new StandradResponse(200, "Success", carDTO), HttpStatus.OK);
    }

    @PutMapping(path = "status")
    public ResponseEntity updateCarAvailableUsingBookingId(String id,String status){

        carService.updateCarAvailableUsingBookingId(id,status);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(params = "update")
    public ResponseEntity updateCarAvailable(String update){

        carService.updateCarAvailable(update);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}

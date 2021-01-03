package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.CarTypeDTO;
import lk.easyrental.spring.dto.UserDTO;
import lk.easyrental.spring.service.CarTypeService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carType")
@CrossOrigin
public class CarTypeController {

    @Autowired
    CarTypeService carTypeService;

    @GetMapping(params = {"type"})
    public ResponseEntity findCarTypeId(@RequestParam String type) {
        CarTypeDTO carTypeUsingName = carTypeService.getCarTypeUsingName(type);
        StandradResponse response = new StandradResponse(200, "Success", carTypeUsingName);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}

package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.*;
import lk.easyrental.spring.service.DriverImageService;
import lk.easyrental.spring.service.DriverService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {
    private static final String UPLOADED_FOLDER = "E:\\CarRentalResource\\Images\\";

    @Autowired
    DriverService driverService;

    @Autowired
    DriverImageService driverImageService;

    @PostMapping
    public ResponseEntity addDriver(@RequestBody DriverDTO dto) {

        String id = UUID.randomUUID().toString();
        dto.setDriver_id(id);

        driverService.saveDriver(dto);
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

                DriverImageDTO driverImageDTO = new DriverImageDTO(UUID.randomUUID().toString(), destinationFile.getName(), id);
                driverImageService.saveDriverImage(driverImageDTO);


            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{random}")
    public ResponseEntity randomDriver() {
        DriverDTO driverDTO = driverService.randomDriver();
        StandradResponse response = new StandradResponse(200, "Success", driverDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"id"})
    public ResponseEntity serchDriver(String id) {
        DriverDTO driverDTO = driverService.searchDriver(id);
        StandradResponse response = new StandradResponse(200, "Success", driverDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @PutMapping(path = "status")
    public ResponseEntity updateDriverStatus(@RequestParam String id,@RequestParam String status) {
        driverService.updateDriverStatus(id,status);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"delete"})
    public ResponseEntity deleteDriver(@RequestParam String delete) {
        driverService.deleteDriver(delete);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}

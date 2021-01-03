package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.CustomerImageDTO;
import lk.easyrental.spring.service.CustomerImageService;
import lk.easyrental.spring.service.CustomerService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    private static final String UPLOADED_FOLDER = "E:\\CarRentalResource\\Images\\";

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerImageService customerImageService;


    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {

        String id = UUID.randomUUID().toString();
        dto.setCustomer_id(id);

        customerService.saveCustomer(dto);
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

                CustomerImageDTO customerImageDTO = new CustomerImageDTO(UUID.randomUUID().toString(), destinationFile.getName(), id);
                customerImageService.saveCustomerImage(customerImageDTO);


            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }



    @GetMapping(params = {"id"})
    public ResponseEntity searchCustomer(@RequestParam String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        StandradResponse response = new StandradResponse(200, "Success", customerDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        customerService.updateCustomer(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"delete"})
    public ResponseEntity deleteCustomer(@RequestParam String delete) {
        customerService.deleteCustomer(delete);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}

package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.BankSlipDTO;
import lk.easyrental.spring.service.BankSlipService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/v1/bank")
@CrossOrigin

public class BankSlipController {

    private static final String UPLOADED_FOLDER = "E:\\CarRentalResource\\Images\\deposit\\";


    @Autowired
    BankSlipService bankSlipService;

    @GetMapping(params = {"id"})
    public ResponseEntity getBankSlip(String id) {
        BankSlipDTO bankSlipDTO = bankSlipService.getBankSlipPathUsingBookingId(id);
        return new ResponseEntity(new StandradResponse(200, "Success", bankSlipDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/uploads/{name:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        File img = new File(UPLOADED_FOLDER + name);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }
}

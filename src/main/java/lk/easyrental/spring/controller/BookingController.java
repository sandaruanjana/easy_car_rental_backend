package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.*;
import lk.easyrental.spring.service.BankSlipService;
import lk.easyrental.spring.service.BookingService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

    private static final String UPLOADED_FOLDER = "E:\\CarRentalResource\\Images\\deposit\\";

    @Autowired
    BookingService bookingService;

    @Autowired
    BankSlipService bankSlipService;

    @PostMapping
    public ResponseEntity addBooking(@RequestBody BookingDTO dto) {

        String id = UUID.randomUUID().toString();
        dto.setBooking_id(id);

        bookingService.saveBooking(dto);
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

                BankSlipDTO bankSlipDTO = new BankSlipDTO(UUID.randomUUID().toString(), destinationFile.getName(), id);
                bankSlipService.saveBankSlip(bankSlipDTO);


            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "status")
    public ResponseEntity updateBookingStatus(@RequestParam String id,@RequestParam String status) {
        bookingService.updateBookingStatus(id,status);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(path = {"cancel"})
    public ResponseEntity cancelBooking(@RequestParam String id,@RequestParam String remark) {
        bookingService.cancelBooking(id,remark);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBookings() {
        List<BookingDTO> allCBookings = bookingService.getAllBookings();
        return new ResponseEntity(new StandradResponse(200, "Success", allCBookings), HttpStatus.OK);
    }

    @GetMapping(path = "pending")
    public ResponseEntity getAllPendingBookings() {
        List<BookingDTO> allPendingBookings = bookingService.getAllPendingBookings();
        return new ResponseEntity(new StandradResponse(200, "Success", allPendingBookings), HttpStatus.OK);
    }

    @GetMapping(path = {"schedule"})
    public ResponseEntity getDriverBookingSchedule(String id) {
        List<BookingDTO> driverBookingSchedule = bookingService.getDriverBookingSchedule(id);
        return new ResponseEntity(new StandradResponse(200, "Success", driverBookingSchedule), HttpStatus.OK);
    }

    @GetMapping(path = {"customer"})
    public ResponseEntity getCustomerBooking(String id) {
        List<BookingDTO> customerBooking = bookingService.getCustomerBooking(id);
        return new ResponseEntity(new StandradResponse(200, "Success", customerBooking), HttpStatus.OK);
    }


}

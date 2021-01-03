package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.BookingDTO;
import lk.easyrental.spring.entity.Booking;
import lk.easyrental.spring.entity.Car;
import lk.easyrental.spring.entity.Customer;
import lk.easyrental.spring.repo.BookingRepo;
import lk.easyrental.spring.repo.CarRepo;
import lk.easyrental.spring.repo.CustomerRepo;
import lk.easyrental.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveBooking(BookingDTO dto) {


        Booking booking = mapper.map(dto, Booking.class);
        bookingRepo.save(booking);

    }

    @Override
    public void updateBooking(BookingDTO dto) {

    }

    @Override
    public BookingDTO searchBooking(String id) {
        return null;
    }

    @Override
    public void deleteBooking(String id) {

    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        return mapper.map(bookings, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

    @Override
    public List<BookingDTO> getAllPendingBookings() {
        List<Booking> data = bookingRepo.getAllPendingBookings();

        return mapper.map(data, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void updateBookingStatus(String id, String status) {
        Optional<Booking> byId = bookingRepo.findById(id);
        if (byId.isPresent()) {
            Booking booking = mapper.map(byId.get(), Booking.class);
            booking.setRent_request(status);
            bookingRepo.save(booking);
        } else {
            throw new RuntimeException("Updating Booking Status Fail!");
        }

    }

    @Override
    public List<BookingDTO> getDriverBookingSchedule(String id) {
        List<BookingDTO> list = new ArrayList<>();
        List<String> driverBookingSchedule = bookingRepo.getDriverBookingSchedule(id);

        for (String data : driverBookingSchedule) {

            Optional<Booking> byId = bookingRepo.findById(data);
            if (byId.isPresent()) {
                BookingDTO map = mapper.map(byId.get(), BookingDTO.class);

                Optional<Customer> customer = customerRepo.findById(byId.get().getCustomer().getCustomer_id());
                map.setCustomer_id(customer.get().getName());

                Optional<Car> car = carRepo.findById(byId.get().getCar().getCar_id());
                map.setCar_id(car.get().getBrand());

                list.add(map);
            } else {
                throw new RuntimeException("get Driver Booking Schedule Fail!");
            }
        }
        return list;

    }

    @Override
    public void cancelBooking(String id, String remark) {
        Optional<Booking> booking = bookingRepo.findById(id);
        if (booking.isPresent()){
            Booking bookingData = mapper.map(booking.get(), Booking.class);
            bookingData.setRent_request("Cancel");
            bookingData.setIsFinish("Cancel");
            bookingData.setStatus("Cancel");
            bookingData.setRemark(remark);
            bookingRepo.save(bookingData);
        }else {
            throw new RuntimeException("Booking Cancel Fail!");
        }

    }

    @Override
    public List<BookingDTO> getCustomerBooking(String id) {
        List<Booking> booking = bookingRepo.getCustomerBooking(id);
        return mapper.map(booking, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }
}

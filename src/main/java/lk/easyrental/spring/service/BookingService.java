package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO dto);

    void updateBooking(BookingDTO dto);

    BookingDTO searchBooking(String id);

    void deleteBooking(String id);

    List<BookingDTO> getAllBookings();

    List<BookingDTO> getAllPendingBookings();

    void updateBookingStatus(String id,String status);

    List<BookingDTO>  getDriverBookingSchedule(String id);

    void cancelBooking(String id,String remark);

    List<BookingDTO> getCustomerBooking(String id);

}

package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.Booking;
import lk.easyrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query(value = "select * from booking where rent_request='Pending'", nativeQuery = true)
    List<Booking> getAllPendingBookings();

    //@Query(value = "SELECT b.booking_id from booking b inner join driver dr on b.driver_id=dr.driver_id where dr.driver_id=?1", nativeQuery = true)
    //@Query(value = "select b from Booking b INNER JOIN b.driver d where d.driver_id=?1")
    @Query(value = "SELECT b.booking_id from booking b inner join driver dr on b.driver_id=dr.driver_id where dr.driver_id=?1 and b.rent_request='Approve'", nativeQuery = true)
    List<String> getDriverBookingSchedule(String id);

    @Query(value = "select * from booking where customer_id=?1", nativeQuery = true)
    List<Booking> getCustomerBooking(String id);
}

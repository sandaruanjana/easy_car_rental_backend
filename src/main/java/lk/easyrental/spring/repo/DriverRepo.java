package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "SELECT * FROM driver  where available='Yes' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Driver randomDriver();

    @Query(value = "select dr.driver_id from driver dr join booking b on dr.driver_id=b.driver_id where b.booking_id=?1", nativeQuery = true)
    String getDriverIdFromBookingId(String id);

    @Modifying
    @Query(value = "update driver set available=?1 where driver_id=?2", nativeQuery = true)
    void updateAvailableStatus(String status,String id);


}

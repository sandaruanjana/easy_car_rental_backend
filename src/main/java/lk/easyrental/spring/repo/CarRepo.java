package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "select distinct car_id from car where available='Yes' and  brand=?1 ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    String findByBrand (String name);

    @Query(value = "select distinct brand from car where available='Yes'", nativeQuery = true)
    List<String> AllAvailableCars();

    @Modifying
    @Query(value = "update car set available='No' where car_id=?1", nativeQuery = true)
    void updateCarAvailable(String id);

    @Query(value = "select cr.car_id from car cr join booking b on cr.car_id=b.car_id where b.booking_id=?1", nativeQuery = true)
    String getCarIdFromBookingId(String id);

    @Modifying
    @Query(value = "update car set available=?1 where car_id=?2", nativeQuery = true)
    void updateCarAvailableStatusUsingCarId(String status,String id);

    @Query(value = "select * from car where brand=?1 limit 1;", nativeQuery = true)
    Car getCarDetailsUsingBrand(String brand);
}

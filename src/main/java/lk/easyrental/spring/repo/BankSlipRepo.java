package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.BankSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankSlipRepo extends JpaRepository<BankSlip,String> {
    @Query(value = "select * from bankslip where booking_id=?1", nativeQuery = true)
    BankSlip getBankSlipPathUsingBookingId(String id);
}

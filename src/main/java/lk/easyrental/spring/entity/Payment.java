package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String payment_id;
    private double used_km;
    private Date date;
    private double amount;
    private double additional_amount;
    private double damage_amount;
    private double total;
    private String status;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id", nullable = false)
    private Booking booking;


}

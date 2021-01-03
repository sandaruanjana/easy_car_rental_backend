package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    private String booking_id;
    private Date pickup_date;
    private String pickup_venue;
    private Date return_date;
    private String return_venue;
    private String driver_status;
    private String rent_duration;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String status;
    private String rent_request;
    private String isFinish;
    private String remark;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Car car;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL, orphanRemoval = true)
    private BankSlip bankSlip;

}

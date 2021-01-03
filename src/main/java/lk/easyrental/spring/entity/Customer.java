package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String customer_id;
    private String email;
    private String name;
    private String gender;
    private String tel;
    private String address;
    private double waiver_amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<CustomerImage> customerImages = new ArrayList<>();


    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings = new ArrayList<>();

}

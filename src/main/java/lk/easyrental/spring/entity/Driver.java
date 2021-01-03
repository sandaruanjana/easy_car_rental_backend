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
public class Driver {
    @Id
    private String driver_id;
    private String name;
    private String gender;
    private String tel;
    private String address;
    private String available;
    private Date date;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<DriverImage> driverImages=new ArrayList<>();

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings=new ArrayList<>();
}

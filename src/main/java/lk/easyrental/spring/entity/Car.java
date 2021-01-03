package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    private String car_id;
    private String brand;
    private int number_of_passengers;
    private String transmission_type;
    private String fuel_type;
    private String registraion_number;
    private String color;
    private String maintain_status;
    private String damage_status;
    private double used_km;

    private double daily_rate;
    private double free_km_day;
    private double monthly_rate;
    private double free_km_month;
    private double cost_extra_km;
    private String available;



    @ManyToOne
    @JoinColumn(name = "car_type_id", referencedColumnName = "car_type_id")
    private CarType carType;

    @OneToMany(mappedBy = "car")
    private List<CarImage> carImages=new ArrayList<>();

    @OneToMany(mappedBy = "car")
    private List<Booking> bookings=new ArrayList<>();
}

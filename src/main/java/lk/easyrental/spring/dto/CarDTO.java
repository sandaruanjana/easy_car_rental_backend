package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
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
    private String car_type_id;
    private String available;
}

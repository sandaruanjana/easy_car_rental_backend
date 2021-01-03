package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarTypeDTO {
    private String car_type_id;
    private String name;
    private String availability;
    private double waiver_amount;
}

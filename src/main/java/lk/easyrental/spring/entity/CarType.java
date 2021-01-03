package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarType {
    @Id
    private String car_type_id;
    private String name;
    private String availability;
    private double waiver_amount;

    @OneToMany(mappedBy = "carType")
    private List<Car> Cars = new ArrayList<>();

}

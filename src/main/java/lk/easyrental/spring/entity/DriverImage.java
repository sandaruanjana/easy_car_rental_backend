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
public class DriverImage {
    @Id
    private String driver_image_id;
    private String driver_image_path;



    @ManyToOne()
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver;

}

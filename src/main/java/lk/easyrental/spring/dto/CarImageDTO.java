package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarImageDTO {
    private String car_image_id;
    private String car_image_path;
    private String car_id;
}

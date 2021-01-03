package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverImageDTO {
    private String driver_image_id;
    private String driver_image_path;
    private String driver_id;
}

package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerImageDTO {
    private String customer_image_id;
    private String customer_image_path;
    private String customer_id;
}

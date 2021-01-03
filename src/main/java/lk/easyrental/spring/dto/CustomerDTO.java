package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customer_id;
    private String email;
    private String name;
    private String gender;
    private String tel;
    private String address;
    private double waiver_amount;

    private String username;
    private String password;
    private String role;
}

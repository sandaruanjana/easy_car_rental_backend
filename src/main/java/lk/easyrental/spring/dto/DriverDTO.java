package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driver_id;
    private String name;
    private String gender;
    private String tel;
    private String address;
    private String available;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String username;
    private String password;
    private String role;
}

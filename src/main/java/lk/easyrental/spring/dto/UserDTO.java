package lk.easyrental.spring.dto;

import lk.easyrental.spring.entity.User;
import lk.easyrental.spring.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String user_id;
    private String username;
    private String password;
    private String user_role_id;
}

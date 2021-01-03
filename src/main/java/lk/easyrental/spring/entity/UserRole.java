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
public class UserRole {
    @Id
    private String user_role_id;
    private String role_type;

    @OneToMany(mappedBy = "userRole")
    private List<User> Users = new ArrayList<>();

}

package lk.easyrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String user_id;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne()
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id")
    private UserRole userRole;
}

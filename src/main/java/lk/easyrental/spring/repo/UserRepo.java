package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsernameEquals(String name);
    User findByUsername(String name);
}

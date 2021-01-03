package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO dto);

    void updateUser(UserDTO dto);

    UserDTO searchUser(String id);

    void deleteUser(String id);

    List<UserDTO> getAllUser();

    boolean findByUsernameEquals(String id);

    UserDTO login(UserDTO dto);

    UserDTO checkUserRole(String id);
}

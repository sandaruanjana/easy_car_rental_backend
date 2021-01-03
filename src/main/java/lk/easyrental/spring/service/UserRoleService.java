package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.UserDTO;
import lk.easyrental.spring.dto.UserRoleDTO;

import java.util.List;

public interface UserRoleService {
    void saveUserRole(UserRoleDTO dto);

    void updateUserRole(UserRoleDTO dto);

    UserRoleDTO searchUserRole(String id);

    void deleteUserRole(String id);

    List<UserRoleDTO> getAllUserRole();

    UserRoleDTO checkUserRoleType(String id);
}

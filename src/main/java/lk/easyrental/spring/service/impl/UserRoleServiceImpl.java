package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.UserRoleDTO;
import lk.easyrental.spring.entity.UserRole;
import lk.easyrental.spring.repo.UserRoleRepo;
import lk.easyrental.spring.service.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveUserRole(UserRoleDTO dto) {
        UserRole userRole = mapper.map(dto, UserRole.class);
        userRoleRepo.save(userRole);

    }

    @Override
    public void updateUserRole(UserRoleDTO dto) {

    }

    @Override
    public UserRoleDTO searchUserRole(String id) {
        return null;
    }

    @Override
    public void deleteUserRole(String id) {

    }

    @Override
    public List<UserRoleDTO> getAllUserRole() {
        return null;
    }

    @Override
    public UserRoleDTO checkUserRoleType(String id) {
        Optional<UserRole> userRole = userRoleRepo.findById(id);
        if (userRole.isPresent()){
            return mapper.map(userRole.get(),UserRoleDTO.class);
        }
        throw new RuntimeException("UserRoleType Find Fail!");
    }
}

package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.UserDTO;
import lk.easyrental.spring.entity.User;
import lk.easyrental.spring.repo.UserRepo;
import lk.easyrental.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        userRepo.save(user);
    }

    @Override
    public void updateUser(UserDTO dto) {

    }

    @Override
    public UserDTO searchUser(String id) {

        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return mapper.map(user.get(),UserDTO.class);
        }else {
            throw new RuntimeException("User Search Fail");
        }

    }

    @Override
    public void deleteUser(String id) {
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public boolean findByUsernameEquals(String id) {
        if (userRepo.findByUsernameEquals(id) != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserDTO login(UserDTO dto) {
        User data = userRepo.findByUsername(dto.getUsername());

        if (dto.getPassword().equals(data.getPassword())){
            UserDTO loginData = mapper.map(data, UserDTO.class);
            return loginData;
        }else {
            throw new RuntimeException("Login Fail!");
        }

    }

    @Override
    public UserDTO checkUserRole(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return mapper.map(user.get(), UserDTO.class);
        }
        throw new RuntimeException("UserRoleID Find Fail!");
    }
}

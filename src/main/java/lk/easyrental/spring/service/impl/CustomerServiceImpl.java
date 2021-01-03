package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.entity.Customer;
import lk.easyrental.spring.entity.User;
import lk.easyrental.spring.entity.UserRole;
import lk.easyrental.spring.repo.CustomerRepo;
import lk.easyrental.spring.repo.UserRepo;
import lk.easyrental.spring.repo.UserRoleRepo;
import lk.easyrental.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {


        if (dto.getRole().equalsIgnoreCase("Customer")) {
            Customer customer = new Customer(dto.getCustomer_id(), dto.getEmail(), dto.getName(), dto.getGender(), dto.getTel(), dto.getAddress(), dto.getWaiver_amount(), new Date(), null, null);
            customerRepo.save(customer);

            UserRole ro = userRoleRepo.getUserRoleIdUsingName("customer");
            User user = new User(dto.getCustomer_id(), dto.getUsername(), dto.getPassword(), ro);
            userRepo.save(user);
        } else {
            throw new RuntimeException("Customer Register Fail!");
        }



    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        Optional<Customer> customer = customerRepo.findById(dto.getCustomer_id());
        if (customer.isPresent()){
            Customer customerClass = mapper.map(customer.get(), Customer.class);
            customerClass.setEmail(dto.getEmail());
            customerClass.setName(dto.getName());
            customerClass.setTel(dto.getTel());
            customerClass.setAddress(dto.getAddress());

            customerRepo.save(customerClass);

            Optional<User> user = userRepo.findById(dto.getCustomer_id());

            if (user.isPresent()){
                User userClass = mapper.map(user.get(), User.class);

                if (dto.getPassword().equalsIgnoreCase(userClass.getPassword())){
                    userClass.setUsername(dto.getUsername());
                    userClass.setPassword(dto.getPassword());
                    userRepo.save(userClass);
                }else {
                    userClass.setUsername(dto.getUsername());
                    userClass.setPassword(dto.getPassword());
                    userRepo.save(userClass);
                }

            }else {
                throw new RuntimeException("User Update Fail!");
            }

        }else {
            throw new RuntimeException("Customer Update Fail!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {

       Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
           return mapper.map(customer.get(),CustomerDTO.class);
        }else {
            throw new RuntimeException("Customer Search Fail!");
        }

    }

    @Override
    public void deleteCustomer(String id) {

        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            userRepo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Delete Fail! Cant Find Driver");
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
}

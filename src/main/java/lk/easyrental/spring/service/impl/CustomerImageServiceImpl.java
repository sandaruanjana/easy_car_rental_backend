package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.CustomerImageDTO;
import lk.easyrental.spring.entity.CustomerImage;
import lk.easyrental.spring.repo.CustomerImageRepo;
import lk.easyrental.spring.service.CustomerImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerImageServiceImpl implements CustomerImageService {

    @Autowired
    CustomerImageRepo customerImageRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomerImage(CustomerImageDTO dto) {

        CustomerImage images = mapper.map(dto, CustomerImage.class);
        customerImageRepo.save(images);

    }

    @Override
    public void updateCustomerImage(CustomerImageDTO dto) {

    }

    @Override
    public CustomerImageDTO searchCustomerImage(String id) {
        return null;
    }

    @Override
    public void deleteCustomerImage(String id) {

    }

    @Override
    public List<CustomerImageDTO> getAllCustomersImages() {
        return null;
    }
}

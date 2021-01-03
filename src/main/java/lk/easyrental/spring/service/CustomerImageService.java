package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.CustomerImageDTO;

import java.util.List;

public interface CustomerImageService {
    void saveCustomerImage(CustomerImageDTO dto);

    void updateCustomerImage(CustomerImageDTO dto);

    CustomerImageDTO searchCustomerImage(String id);

    void deleteCustomerImage(String id);

    List<CustomerImageDTO> getAllCustomersImages();
}

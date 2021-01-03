package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.CustomerImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerImageRepo extends JpaRepository<CustomerImage,String> {
}

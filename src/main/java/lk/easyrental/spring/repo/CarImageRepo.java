package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepo extends JpaRepository<CarImage,String> {
}

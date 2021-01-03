package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepo extends JpaRepository<CarType,String> {
    CarType findByName (String name);
}

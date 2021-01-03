package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.CarImageDTO;
import lk.easyrental.spring.entity.CarImage;
import lk.easyrental.spring.repo.CarImageRepo;
import lk.easyrental.spring.service.CarImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarImageServiceImpl implements CarImageService {

    @Autowired
    CarImageRepo carImageRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCarImage(CarImageDTO dto) {
        CarImage carImage = mapper.map(dto, CarImage.class);
        carImageRepo.save(carImage);

    }

    @Override
    public void updateCarImage(CarImageDTO dto) {

    }

    @Override
    public CarImageDTO searchCarImage(String id) {
        return null;
    }

    @Override
    public void deleteCarImage(String id) {

    }

    @Override
    public List<CarImageDTO> getAllCarImages() {
        return null;
    }
}

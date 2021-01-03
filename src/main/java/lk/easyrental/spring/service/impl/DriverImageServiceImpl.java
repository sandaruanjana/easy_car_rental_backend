package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.DriverImageDTO;
import lk.easyrental.spring.entity.DriverImage;
import lk.easyrental.spring.repo.DriverImageRepo;
import lk.easyrental.spring.service.DriverImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverImageServiceImpl implements DriverImageService {

    @Autowired
    DriverImageRepo driverImageRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriverImage(DriverImageDTO dto) {
        DriverImage driverImage = mapper.map(dto, DriverImage.class);
        driverImageRepo.save(driverImage);
    }

    @Override
    public void updateDriverImage(DriverImageDTO dto) {

    }

    @Override
    public DriverImageDTO searchDriverImage(String id) {
        return null;
    }

    @Override
    public void deleteDriverImage(String id) {

    }

    @Override
    public List<DriverImageDTO> getAllDriversImages() {
        return null;
    }
}

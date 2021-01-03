package lk.easyrental.spring.service.impl;

import lk.easyrental.spring.dto.BankSlipDTO;
import lk.easyrental.spring.entity.BankSlip;
import lk.easyrental.spring.repo.BankSlipRepo;
import lk.easyrental.spring.service.BankSlipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankSlipServiceImpl implements BankSlipService {

    @Autowired
    BankSlipRepo bankSlipRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveBankSlip(BankSlipDTO dto) {
        BankSlip bankSlip = mapper.map(dto, BankSlip.class);
        bankSlipRepo.save(bankSlip);
    }

    @Override
    public void updateBankSlip(BankSlipDTO dto) {

    }

    @Override
    public BankSlipDTO searchBankSlip(String id) {
        return null;
    }

    @Override
    public void deleteBankSlip(String id) {

    }

    @Override
    public List<BankSlipDTO> getAllBankSlips() {
        return null;
    }

    @Override
    public BankSlipDTO getBankSlipPathUsingBookingId(String id) {
        BankSlip bankSlip = bankSlipRepo.getBankSlipPathUsingBookingId(id);
        return mapper.map(bankSlip,BankSlipDTO.class);
    }
}

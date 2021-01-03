package lk.easyrental.spring.service;

import lk.easyrental.spring.dto.BankSlipDTO;

import java.util.List;

public interface BankSlipService {
    void saveBankSlip(BankSlipDTO dto);

    void updateBankSlip(BankSlipDTO dto);

    BankSlipDTO searchBankSlip(String id);

    void deleteBankSlip(String id);

    List<BankSlipDTO> getAllBankSlips();

    BankSlipDTO getBankSlipPathUsingBookingId(String id);


}

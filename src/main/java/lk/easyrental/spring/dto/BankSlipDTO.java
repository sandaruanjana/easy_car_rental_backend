package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankSlipDTO {
    private String bank_slip_id;
    private String image_path;
    private String booking_id;
}

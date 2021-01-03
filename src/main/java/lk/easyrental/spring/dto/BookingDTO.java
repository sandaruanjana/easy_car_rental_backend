package lk.easyrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String booking_id;
    private Date pickup_date;
    private String pickup_venue;
    private Date return_date;
    private String return_venue;
    private String driver_status;
    private String rent_duration;
    private Date date;
    private String status;
    private String rent_request;
    private String isFinish;
    private String remark;

    private String customer_id;
    private String driver_id;
    private String car_id;


}

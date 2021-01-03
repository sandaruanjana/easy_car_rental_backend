package lk.easyrental.spring.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandradResponse {
    private int code;
    private String message;
    private Object data;
}

package pl.qc.spring.kafka;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCommand {

    private String orderId;
    private String item;
    private String quantity;
}

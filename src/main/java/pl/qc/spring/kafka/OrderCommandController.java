package pl.qc.spring.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderCommandController {

    @Value("${kafka.topics.order-command}")
    private String orderCommandTopic;

    private final OrderCommandProducer orderCommandProducer;

    @PostMapping(path = "/orders/commands")
    public ResponseEntity<String> sendCommand() {
        try {
            OrderCommand command = OrderCommand.builder()
                    .orderId(UUID.randomUUID().toString())
                    .item("Item" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                    .quantity("dużo")
                    .build();
            orderCommandProducer.sendOrder(orderCommandTopic, command);
            return new ResponseEntity<>("Order command sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

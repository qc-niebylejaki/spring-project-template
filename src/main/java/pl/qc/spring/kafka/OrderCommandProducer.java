package pl.qc.spring.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCommandProducer {

    private final KafkaTemplate<String, OrderCommand> kafkaTemplate;

    public void sendOrder(String topic, OrderCommand orderCommand) throws ExecutionException, InterruptedException, TimeoutException {
        SendResult<String, OrderCommand> sendResult = kafkaTemplate.send(topic, orderCommand)
                .get(5, TimeUnit.SECONDS);
        log.info("Sent order - offset: {}, partition: {}, timestamp: {}",
                sendResult.getRecordMetadata().offset(),
                sendResult.getRecordMetadata().partition(),
                sendResult.getRecordMetadata().timestamp());
    }
}

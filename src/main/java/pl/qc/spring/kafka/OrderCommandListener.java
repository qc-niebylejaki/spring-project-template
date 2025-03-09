package pl.qc.spring.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCommandListener {

    @KafkaListener(topics = "${kafka.topics.order-command}", concurrency = "${spring.kafka.listener.concurrency}")
    public void handleInit(final ConsumerRecord<String, OrderCommand> record, final Acknowledgment ack) {
        log.info("Received message {} with key: {}, offset: {}, and partition: {}",
                record.value(), record.key(), record.offset(), record.partition());
        record.value();
        ack.acknowledge();
    }
}

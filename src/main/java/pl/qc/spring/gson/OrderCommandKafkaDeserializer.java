package pl.qc.spring.gson;

import pl.qc.spring.kafka.OrderCommand;

public class OrderCommandKafkaDeserializer extends GsonKafkaDeserializer<OrderCommand> {

    public OrderCommandKafkaDeserializer() {
        super(OrderCommand.class);
    }
}

package pl.qc.spring.gson;

import org.apache.kafka.common.serialization.Serializer;

public class GsonKafkaSerializer<T> implements Serializer<T> {

    @Override
    public byte[] serialize(String topic, T data) {
        if (data == null) {
            return null;
        }
        return GsonProvider.GSON.toJson(data).getBytes();
    }
}

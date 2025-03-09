package pl.qc.spring.gson;

import com.google.gson.JsonParseException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;

@RequiredArgsConstructor
public class GsonKafkaDeserializer<T> implements Deserializer<T> {

    private final Class<T> clazz;

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return GsonProvider.GSON.fromJson(new String(data), clazz);
        } catch (JsonParseException e) {
            throw new RuntimeException("Failed to deserialize JSON", e);
        }
    }
}

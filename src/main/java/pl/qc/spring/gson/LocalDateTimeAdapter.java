package pl.qc.spring.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    @Override
    public JsonElement serialize(LocalDateTime LocalDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return Optional.ofNullable(LocalDateTime)
                .map(value -> new JsonPrimitive(LocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .orElse(null);
    }

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Optional.ofNullable(jsonElement)
                .map(JsonElement::getAsString)
                .map(value -> LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .orElse(null);
    }
}

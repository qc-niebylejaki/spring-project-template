package pl.qc.spring.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return Optional.ofNullable(localDate)
                .map(value -> new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)))
                .orElse(null);
    }

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Optional.ofNullable(jsonElement)
                .map(JsonElement::getAsString)
                .map(value -> LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE))
                .orElse(null);
    }
}

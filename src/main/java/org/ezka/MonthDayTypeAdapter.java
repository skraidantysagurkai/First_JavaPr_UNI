package org.ezka;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

// This adapter is needed to read and write MonthDay types from and to Json
public class MonthDayTypeAdapter implements JsonSerializer<MonthDay>, JsonDeserializer<MonthDay> {

    // Providing a format on how a date should be represented
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");

    // Overriding the serialization of a MonthDay type
    @Override
    public JsonElement serialize(MonthDay monthDay, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(monthDay));
    }

    // Overriding the deserialization of a MonthDay type
    @Override
    public MonthDay deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return MonthDay.parse(json.getAsString(), formatter);
    }
}

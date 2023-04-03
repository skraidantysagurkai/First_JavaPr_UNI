package org.ezka;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.UUID;

// This adapter is needed to read and write UUID type objects to and from Json
public class UUIDTypeAdapter extends com.google.gson.TypeAdapter<UUID> {

    // Overriding read protocol
    @Override
    public UUID read(JsonReader in) throws IOException {
        return UUID.fromString(in.nextString());
    }

    // Overriding writing protocol
    @Override
    public void write(JsonWriter out, UUID value) throws IOException {
        out.value(value.toString());
    }
}

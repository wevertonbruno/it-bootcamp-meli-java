package com.example.spring3pratica1.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JsonReader {
    public static <T> T read(String path, Class<T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new URL(path), type);
    }
}

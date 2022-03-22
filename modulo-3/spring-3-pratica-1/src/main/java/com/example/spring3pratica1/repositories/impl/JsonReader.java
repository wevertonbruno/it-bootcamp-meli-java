package com.example.spring3pratica1.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

/**
 * Util class to handle Json files
 */
public class JsonReader {

    /**
     * Reads a json file and returns a java object instance of type 'classType'
     * @param path
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T read(String path, Class<T> classType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new URL(path), classType);
    }
}

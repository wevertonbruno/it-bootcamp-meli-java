package com.example.spring3pratica1.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Util class to handle Json files
 * @author https://github.com/wevertonbruno
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

    /**
     * Reads a json file and returns a List of classType's object
     * @param path
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> List<T> readAsList(String path, Class<T[]> classType) throws IOException {
        return Arrays.asList(read(path, classType));
    }
}

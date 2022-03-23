package com.example.spring3pratica1.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Util class to handle Json files
 * @author https://github.com/wevertonbruno
 */
public class JsonUtil {

    private static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Reads a json file and returns a java object instance of type 'classType'
     * @param path
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T read(String path, Class<T> classType) throws IOException {
        return MAPPER.readValue(
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

    /**
     * Save the object as a file
     * @param path
     * @param payload
     * @param <T>
     * @throws IOException
     */
    public static <T> void saveAsFile(String path, T payload) throws IOException {
        MAPPER.writeValue(new File(new URL(path).getFile()), payload);
    }
}

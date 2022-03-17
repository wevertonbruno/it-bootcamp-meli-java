package br.com.meli.spring1pratica2.controllers.DTO;

public class MorseResponse {
    private String message;

    public MorseResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MorseResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}

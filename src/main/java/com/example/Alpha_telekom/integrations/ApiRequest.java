package com.example.Alpha_telekom.integrations;

import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.logging.Logger;

@Service
public class ApiRequest {
    private static final Logger logger = Logger.getLogger(ApiRequest.class.getName());

    public boolean sendRequest() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Создание запроса
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.restful-api.dev/objects"))
                    .GET()
                    .build();

            // Выполнение запроса
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Логирование ответа
            logger.info("Response status code: " + response.statusCode());
            logger.info("Response body: " + response.body());
        } catch (Exception e) {
            logger.severe("Error during API call: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

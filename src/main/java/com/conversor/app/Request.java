package com.conversor.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.github.cdimascio.dotenv.Dotenv;

public class Request {
    
    


        public static String request(String pair1, String pair2, int amount) throws IOException, InterruptedException{
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("api_key");
            String url =String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%d",apiKey,pair1,pair2,amount);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString()); 
            return response.body();
        }



}

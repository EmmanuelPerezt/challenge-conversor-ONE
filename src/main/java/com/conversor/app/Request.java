package com.conversor.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import io.github.cdimascio.dotenv.Dotenv;

public class Request {
    
    


        public static float request(String pair1, String pair2, int amount)  {
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("api_key");
            //hacer peticion
            String url =String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%d",apiKey,pair1,pair2,amount);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            try {
                HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString()); 
            //parsear a un objeto
            String json= response.body();
            Gson gson =new Gson();
            Converter converter= gson.fromJson(json, Converter.class);
            
            return converter.getValue();
            } catch (Exception e) {
                return 0f;
            }
        }



}

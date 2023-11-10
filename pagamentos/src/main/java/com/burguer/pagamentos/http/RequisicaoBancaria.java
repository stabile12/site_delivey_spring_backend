package com.burguer.pagamentos.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class RequisicaoBancaria {

  public HttpResponse<String> dispararRequisicaoPost(String uri, Object object) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("objeto" + object);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(new Gson().toJson(object)))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}

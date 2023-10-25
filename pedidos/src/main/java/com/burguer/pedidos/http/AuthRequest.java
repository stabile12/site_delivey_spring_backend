package com.burguer.pedidos.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class AuthRequest {

  public String request(String token, String url) {
    StringBuilder responseContent = new StringBuilder();

    try {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Configura a requisição como POST
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        // Envia o conteúdo no corpo da requisição
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(token);
            wr.flush();
        }

        // Obtém a resposta do servidor
        int responseCode = con.getResponseCode();

        // Lê a resposta do servidor
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return responseContent.toString();
}
}

package controleCondominioApp.model.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepController {
    
    public static String obterEnderecoPorCep(String cep) {
        try {
            String urlStr = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch address from ViaCep for CEP: " + cep, e);
        }
    }
}


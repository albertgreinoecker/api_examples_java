package at.ac.htlinn.aimodels;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiExampleHttpRequest {
    public static void main(String[] args) throws Exception {

        Dotenv dotenv = Dotenv.load();
        final String API_KEY = dotenv.get("GEMINI_API_KEY");
        String body = """
        {
          "contents": [{
            "parts": [{"text": "Explain Java in one sentence"}]
          }]
        }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String json =  response.body();
        System.out.println(json);

        //Use jackson to process JSON Response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        // 👉 Text extrahieren
        String reply = root
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();

        System.out.println("Antwort:");
        System.out.println(reply);
    }
}
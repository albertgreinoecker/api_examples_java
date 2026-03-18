package at.ac.htlinn.aimodels;

import com.google.genai.types.GenerateContentResponse;
import io.github.cdimascio.dotenv.Dotenv;

import com.google.genai.Client;

public class GeminiExampleGoogleLib {
    public static void main(String[] args) throws Exception {

        Dotenv dotenv = Dotenv.load();
        final String API_KEY = dotenv.get("GEMINI_API_KEY");

        Client client = Client.builder().apiKey(API_KEY).build();
        String prompt = "What is the easiest programming language?";

        GenerateContentResponse response =
                client.models.generateContent("gemini-2.5-flash", prompt, null);

        // Gets the text string from the response by the quick accessor method `text()`.
        System.out.println("Unary response: " + response.text());

        // Gets the http headers from the response.
        response
                .sdkHttpResponse()
                .ifPresent(
                        httpResponse ->
                                System.out.println("Response headers: " + httpResponse.headers().orElse(null)));
    }

}

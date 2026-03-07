package at.ac.htlinn;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APITestCallsJackson {
    static final String URL = "https://jsonplaceholder.typicode.com/todos/3";
    public static void withHttpClient() throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Todo todo = mapper.readValue(response.body(), Todo.class);
        System.out.println(todo.getTitle());

    }
    public static void withOkHttp() throws Exception
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper mapper = new ObjectMapper();
        Todo todo = mapper.readValue(response.body().string(), Todo.class);

        System.out.println(todo.getTitle());
    }
}

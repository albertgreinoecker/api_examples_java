package at.ac.htlinn.openweather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

public class WeatherApp {

    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        final String API_KEY = dotenv.get("OPENWEATHER_API_KEY");

        String url =
                "https://api.openweathermap.org/data/2.5/weather?q=Innsbruck&units=metric&appid="
                        + API_KEY;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        String res = response.body();
        System.out.println(res);

        OpenWeatherResponse weather =
                mapper.readValue(res, OpenWeatherResponse.class);

        System.out.println("Stadt: " + weather.getName());
        System.out.println("Temperatur: " + weather.getMain().getTemp() + " °C");
        System.out.println("Feuchtigkeit: " + weather.getMain().getHumidity() + "%");
        System.out.println("Beschreibung: "
                + weather.getWeather().get(0).getDescription());
    }
}
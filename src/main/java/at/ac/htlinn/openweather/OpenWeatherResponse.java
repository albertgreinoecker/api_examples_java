package at.ac.htlinn.openweather;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {

    private String name;
    @JsonProperty("main")
    private WeatherData data;
    private List<Weather> weather;

    public OpenWeatherResponse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherData getMain() {
        return data;
    }

    public void setMain(WeatherData data) {
        this.data = data;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
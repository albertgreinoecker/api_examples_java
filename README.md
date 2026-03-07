# API Examples Java

Small Java examples for calling REST APIs with:

- Java `HttpClient`
- `OkHttp`
- JSON mapping with `Jackson`
- Environment variables with `java-dotenv`

## Requirements

- Java 21
- Maven 3.9+

## Build

```bash
mvn clean package
```

## Run

From IntelliJ, run one of these main classes:

- `at.ac.htlinn.Main` (JSONPlaceholder example)
- `at.ac.htlinn.openweather.WeatherApp` (OpenWeather example)

## `.env` configuration

The OpenWeather example reads the API key from a `.env` file in the project root.

Create or update `.env`:

```env
OPENWEATHER_API_KEY=your_api_key_here
```

Variable description:

- `OPENWEATHER_API_KEY`: Your OpenWeather API key used by `WeatherApp`.

Notes:

- Keep `.env` private and never share real API keys.
- `.env` is already ignored by Git in `.gitignore`.

# API Examples Java

This project contains small API examples centered around Java 21 and Maven. It shows different ways to call HTTP APIs, deserialize JSON with Jackson, load secrets from a `.env` file, and combine a Java client with a small FastAPI service.

## Project Structure

### Java examples

The Java sources are under `src/main/java` and include:

- `at.ac.htlinn.APITestCalls`: simple GET requests with Java `HttpClient` and `OkHttp`
- `at.ac.htlinn.APITestCallsJackson`: JSON deserialization into a `Todo` object with Jackson
- `at.ac.htlinn.openweather.WeatherApp`: OpenWeather request with JSON mapping into Java classes
- `at.ac.htlinn.aimodels.GeminiExampleHttpRequest`: Gemini API request using Java `HttpClient`
- `at.ac.htlinn.fastapi.NetflixFastApiOkHttpExample`: OkHttp example for a Netflix/RapidAPI request

### FastAPI example

The `fastapi_netflix_example` folder contains a small Python FastAPI app that exposes a local `/netflix/search` endpoint and forwards requests to the upstream Netflix RapidAPI service.

## Tech Stack

- Java 21
- Maven
- Jackson
- OkHttp
- `java-dotenv`
- Python FastAPI
- `httpx`

## Build

```bash
mvn clean package
```

## Running Examples

You can run the Java examples from IntelliJ or by targeting their main classes directly.

Useful entry points:

- `at.ac.htlinn.APITestCalls`
- `at.ac.htlinn.APITestCallsJackson`
- `at.ac.htlinn.openweather.WeatherApp`
- `at.ac.htlinn.aimodels.GeminiExampleHttpRequest`
- `at.ac.htlinn.fastapi.NetflixFastApiOkHttpExample`

To start the FastAPI example:

```bash
cd fastapi_netflix_example
pip install -r requirements.txt
uvicorn main:app --reload
```

Then call it locally, for example:

```bash
curl "http://127.0.0.1:8000/netflix/search?title=dark"
```

## Environment Variables

The project uses a root `.env` file for API credentials and host configuration.

Keys currently present in `.env`:

- `OPENWEATHER_API_KEY`
- `NETFLIX_API_KEY`
- `NETFLIX_API_HOST`
- `NETFLIX_API_BASE_URL`
- `GEMINI_API_KEY`

Do not commit real secret values to version control.

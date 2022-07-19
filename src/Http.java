import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

/**
 * Http
 */
public class Http {

    private URI uri;

    public Http(URI uri) {
        this.uri = uri;
    }

    public List<Map<String, String>> get() throws IOException, InterruptedException {
        HttpClient http = HttpClient.newHttpClient();
        HttpResponse<String> response;

        response = http.send(HttpRequest
                .newBuilder()
                .uri(this.uri)
                .build(),
                BodyHandlers.ofString());

        String body = response.body();

        JsonParser parser = new JsonParser();

        return parser.parse(body);
    }

}

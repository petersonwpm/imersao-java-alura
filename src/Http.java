import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Http
 */
public class Http {

    private URI uri;

    public Http(URI uri) {
        this.uri = uri;
    }

    public HttpResponse<String> get() throws IOException, InterruptedException {
        return HttpClient.newHttpClient()
            .send(HttpRequest
                .newBuilder()
                .uri(this.uri)
                .build(),
                BodyHandlers.ofString());
    }

}

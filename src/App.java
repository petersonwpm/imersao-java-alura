import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    private static HttpResponse<String> response;

    public static void main(String[] args) throws Exception {

        URI url = URI.create("https://api.mocki.io/v2/549a5d8b");

        HttpClient http = HttpClient.newHttpClient();
        HttpResponse<String> response = http.send(HttpRequest
                .newBuilder()
                .uri(url)
                .build(),
                BodyHandlers.ofString());

        String body = response.body();


        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}

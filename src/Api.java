import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Api
 */
public class Api {

    public static void getSeries() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250TVs"););

        List<Map<String, String>> listaDeSeries = http.get();

        for (Map<String,String> filme : listaDeSeries) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
        }
    }

    public static void getMovies() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b"));

        List<Map<String, String>> listaDeFilmes = http.get();

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}
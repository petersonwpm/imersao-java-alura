import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Api
 */
public class Api {

    public static List<Map<String, String>> getSeries() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250TVs"););
        return http.get();
    }

    public static List<Map<String, String>> getMovies() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b"));
        return http.get();
    }
}
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Api
 */
public class IMBDApiExtractor {

    public static List<Content> getSeries() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250TVs"));
        JsonParser parser = new JsonParser();

        List<Map<String, String>> items = parser.parse(http.get().body());

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> item : items) {
            contents.add(
                    new Content(
                            item.get("title"),
                            item.get("image"),
                            (int) Float.parseFloat(item.get("imDbRating")),
                            item.get("year")));
        }

        return contents;
    }

    public static List<Content> getMovies() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250Movies"));
        JsonParser parser = new JsonParser();

        List<Map<String, String>> items = parser.parse(http.get().body());

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> item : items) {
            contents.add(
                    new Content(
                            item.get("title"),
                            item.get("image"),
                            (int) Float.parseFloat(item.get("imDbRating")),
                            item.get("year")));
        }

        return contents;

    }
}

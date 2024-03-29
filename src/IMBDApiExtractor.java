import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Api
 */
public class IMBDApiExtractor {

    public static List<ContentRecord> getSeries()  {
        try {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250TVs"));
        JsonParser parser = new JsonParser();

        List<Map<String, String>> items = parser.parse(http.get().body());

        List<ContentRecord> contents = new ArrayList<>();

        for (Map<String, String> item : items) {
            contents.add(
                    new ContentRecord(
                            item.get("title"),
                            item.get("image"),
                            (int) Float.parseFloat(item.get("imDbRating")),
                            item.get("year")));
        }

        return contents;
        } catch(IOException | InterruptedException ex) {
            throw new HttpException(ex.getMessage());
        }
    }

    public static List<ContentRecord> getMovies() throws IOException, InterruptedException {
        Http http = new Http(URI.create("https://api.mocki.io/v2/549a5d8b/Top250Movies"));
        JsonParser parser = new JsonParser();

        List<Map<String, String>> items = parser.parse(http.get().body());

        List<ContentRecord> contents = new ArrayList<>();

        for (Map<String, String> item : items) {
            contents.add(
                    new ContentRecord(
                            item.get("title"),
                            item.get("image"),
                            (int) Float.parseFloat(item.get("imDbRating")),
                            item.get("year")));
        }

        return contents;

    }
}

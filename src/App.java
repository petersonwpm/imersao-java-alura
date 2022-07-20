import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, String>> movies;
        List<Map<String, String>> series;
        int opt;
        do {
            View.menu();

            opt = scanner.nextInt();

            switch (opt) {
                case 0:
                    // end
                    scanner.close();
                    break;

                case 1:
                    movies = Api.getMovies();
                    for (Map<String, String> movie : movies) {
                        View.show(movie);
                    }
                    break;
                case 2:
                    series = Api.getSeries();
                    for (Map<String, String> serie : series) {
                        View.show(serie);
                    }
                    break;
                case 3:
                    movies = Api.getMovies();
                    series = Api.getMovies();

                    movies.addAll(series);

                    for (Map<String,String> movie : movies) {
                        Sticker.generate(movie);
                    }

                    break;
                default:
                    break;
            }
        } while (opt != 0);
    }
}

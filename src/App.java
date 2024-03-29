import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<ContentRecord> movies;
        List<ContentRecord> series;
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
                    movies = IMBDApiExtractor.getMovies();
                    for (ContentRecord movie : movies) {
                        View.show(movie);
                    }
                    break;
                case 2:
                    series = IMBDApiExtractor.getSeries();
                    for (ContentRecord serie : series) {
                        View.show(serie);
                    }
                    break;
                case 3:
                    movies = IMBDApiExtractor.getMovies();
                    series = IMBDApiExtractor.getMovies();

                    movies.addAll(series);

                    for (ContentRecord movie : movies) {
                        Sticker.generate(movie);
                    }

                    break;
                default:
                    break;
            }
        } while (opt != 0);
    }
}

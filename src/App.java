import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Content> movies;
        List<Content> series;
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
                    for (Content movie : movies) {
                        View.show(movie);
                    }
                    break;
                case 2:
                    series = Api.getSeries();
                    for (Content serie : series) {
                        View.show(serie);
                    }
                    break;
                case 3:
                    movies = Api.getMovies();
                    series = Api.getMovies();

                    movies.addAll(series);

                    for (Content movie : movies) {
                        Sticker.generate(movie);
                    }

                    break;
                default:
                    break;
            }
        } while (opt != 0);
    }
}

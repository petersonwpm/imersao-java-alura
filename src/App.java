import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
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
                    List<Map<String, String>> movies = Api.getMovies();
                    for (Map<String, String> movie : movies) {
                        System.out.println(movie);
                        View.show(movie);
                    }
                    break;
                case 2:
                    List<Map<String, String>> series = Api.getSeries();
                    for (Map<String, String> serie : series) {
                        View.show(serie);
                    }
                    break;

                default:
                    break;
            }
        } while (opt != 0);
    }
}

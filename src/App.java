import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n\n### \uD83D\uDCFA MENU \uD83D\uDCFA ####");
            System.err.println("0 - Sair");
            System.out.println("1 - Listar os melhores filmes");
            System.out.println("2 - Listar as melhores series");
            System.err.print("Qual a sua escolha?: ");

            opt = scanner.nextInt();

            switch (opt) {
                case 0:
                    // end
                    scanner.close();
                    break;

                case 1:
                    List<Map<String, String>> movies = Api.getMovies();
                    for (Map<String, String> movie : movies) {
                        View.show(movie);
                    }
                case 2:
                    List<Map<String, String>> series = Api.getSeries();
                    for (Map<String, String> serie : series) {
                        View.show(serie);
                    }

                default:
                    break;
            }
        } while (opt != 0);
    }

}
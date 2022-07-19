import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("### MENU ####");
        System.err.println("0 - Sair");
        System.out.println("1 - Listar os melhores filmes");
        System.out.println("2 - Listar as melhores series");
        System.err.print("Qual a sua escolha?: ");

        Scanner scanner = new Scanner(System.in);

        int opt = scanner.nextInt();

        scanner.close();

        switch (opt) {
            case 0:
                // end
                break;
            
            case 1:
                getMovies();
            
            case 2:
                getSeries();
        
            default:
                break;
        }
        
        

    }

    private static void getSeries() throws IOException, InterruptedException {
        URI uri = URI.create("https://api.mocki.io/v2/549a5d8b/Top250TVs");

        Http http = new Http(uri);

        List<Map<String, String>> listaDeSeries = http.get();

        for (Map<String,String> filme : listaDeSeries) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
        }
    }

    private static void getMovies() throws IOException, InterruptedException {
        URI uri = URI.create("https://api.mocki.io/v2/549a5d8b");

        Http http = new Http(uri);

        List<Map<String, String>> listaDeFilmes = http.get();

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}
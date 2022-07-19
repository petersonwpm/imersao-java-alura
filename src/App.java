import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

                        URL url = new URL(movie.get("image"));
                        InputStream input = url.openStream();

                        String movieName = movie.get("title").toLowerCase().replaceAll("\s","-") + ".jpg";

                        File f =  new File(movieName);
                        File currentDir = new File(System.getProperty("user.dir"));

                        File out = new File(currentDir.getParent(), "output"); 
                        
                        if (!out.exists() && !out.canWrite()) throw new IOException("Não é possivel criar o diretório" + out.getPath());

                        out.mkdir();


                        System.out.println(out.getPath() +"/"+ f.getName());
                        // if (!f.canWrite()) throw new IOException();

                        FileOutputStream output = new FileOutputStream(out.getPath() +"/"+ f.getName());

                        output.write(input.readAllBytes());

                        output.flush();
                        input.close();
                        output.close();

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

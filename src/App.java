import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

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
                        /** @todo: identificar o mime type */
                        InputStream input = url.openStream();
                        System.out.println( url.getUserInfo());

                        String movieName = movie.get("title").toLowerCase().replaceAll("[.',:]","").replaceAll("[\s]","-") + ".png";

                        File f =  new File(movieName);
                        File currentDir = new File(System.getProperty("user.dir"));

                        BufferedImage image = ImageIO.read(input);

                        Graphics2D graphics = image.createGraphics();

                        graphics.drawString(movieName, 100, 100);

                        File out = new File(currentDir.getParent(), "output"); 

                        System.out.println(out.getPath());
                            
                        if (!out.exists() && !out.canWrite()) throw new IOException("Não é possivel criar o diretório " + out.getPath());

                        out.mkdir();

                        File output = new File(out.getPath() +"/"+ f.getName());

                        // output.write(input.readAllBytes());
                        ImageIO.write( image, "png", output); // output.flush();
                        input.close();
                        // output.close();

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

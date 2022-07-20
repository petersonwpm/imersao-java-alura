import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class Sticker {
    public static void generate(Content content) throws IOException {
        URL url = new URL(content.getUrlImage());
        /** @todo: identificar o mime type */
        InputStream stream = url.openStream();

        String movieName = content
            .getTitle()
            .toLowerCase()
            .replaceAll("[.',:]","")
            .replaceAll("[\s]","-") + ".png";

        File currentDir = new File(System.getProperty("user.dir"));

        BufferedImage image = ImageIO.read(stream);
        BufferedImage resImage = new BufferedImage(image.getWidth(), image.getHeight() + 200, BufferedImage.OPAQUE);

        Graphics2D graphics = resImage.createGraphics();
        graphics
            .drawImage(image, 0, 0, null);

        graphics
            .setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

        graphics
            .drawString(
                    content.getRating() >= 9 
                    ? "Bah, Loco d'especial " + content.getRating()
                    : "Nem pra saída " + content.getRating(), 100, image.getHeight() + 100);

        File out = new File(currentDir.getParent(), "output"); 

        if (!out.exists() && !out.canWrite()) throw new IOException("Não é possivel criar o diretório " + out.getPath());

        out.mkdir();

        File output = new File(out.getPath() + "/" + movieName);

        // output.write(input.readAllBytes());
        ImageIO.write( resImage, "png", output); // output.flush();
        stream.close();
        // output.close();
    }
}

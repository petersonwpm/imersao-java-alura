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
        System.out.println(content.getUrlImage());
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
        Double w = image.getWidth() * 0.3;
        Double h = image.getHeight() * 0.3;

        BufferedImage sticker = new BufferedImage(
                w.intValue(),
                h.intValue(),
                BufferedImage.OPAQUE
                );
        
        Graphics2D g2dSticker = sticker.createGraphics();
        g2dSticker
            .drawImage(image, 0, 0, w.intValue(), h.intValue(), null);

        BufferedImage resImage = new BufferedImage(
                w.intValue(),
                h.intValue() + 100,
                BufferedImage.TRANSLUCENT
        );

        Graphics2D g2dNew = resImage.createGraphics();
        g2dNew
            .drawImage(sticker, 0, 0, null);

        g2dNew
            .setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        g2dNew
            .drawString(
                    content.getRating() >= 9 
                    ? "Bah, Loco d'especial " + content.getRating()
                    : "Nem pra saída " + content.getRating(), w.intValue() / 4, h.intValue() + 50);

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

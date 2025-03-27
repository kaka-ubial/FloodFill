import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    BufferedImage imagem;
    int corOriginal;
    int width;
    int height;

    public Image(String caminhoArquivo) {
        try {
            imagem = ImageIO.read(new File(caminhoArquivo));
            corOriginal = imagem.getRGB(0, 0);
            width = imagem.getWidth();
            height = imagem.getHeight();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a imagem.", e);
        }
    }

    public int getCorOriginal() {
        return corOriginal;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public int getRGB(int x, int y) {
        return imagem.getRGB(x, y);
    }

    public void setRGB(int x, int y, int color) {
        imagem.setRGB(x, y, color);
    }
}

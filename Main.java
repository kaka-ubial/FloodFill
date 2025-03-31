import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Image imagem = new Image("test.png");
        FloodFill flood = new FloodFill(imagem);

        JFrame frame = new JFrame("Flood Fill - Estrutura de Dados");
        Panel panel = new Panel(imagem);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(imagem.getWidth(), imagem.getHeight());
        frame.add(panel);
        frame.setVisible(true);

        flood.stackFill(panel, 0, 0);
    }
}

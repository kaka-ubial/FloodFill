import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Panel extends JPanel {
    private Image imagem;

    public Panel(Image imagem) {
        this.imagem = imagem;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem.getImagem(), 0, 0, null);  // Desenha a imagem na tela
    }
}
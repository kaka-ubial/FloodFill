import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {
    MyStack<Integer> stack = new MyStack<>();
    MyQueue<Integer> queue = new MyQueue<>();
    int esmeralda = 0xFF50C878;
    BufferedImage imagem;

    public FloodFill(Image imagem) {
        this.imagem = imagem.getImagem();
    }

    public void stackFill(JPanel panel, int startX, int startY) {
        if (startX < 0 || startX >= imagem.getWidth() || startY < 0 || startY >= imagem.getHeight()) {
            throw new IllegalArgumentException("Ponto inicial fora dos limites da imagem!");
        }

        int pointZero = imagem.getRGB(startX, startY);

        if (pointZero == esmeralda) {
            return;
        }

        stack.push(startX);
        stack.push(startY);

        boolean[][] visited = new boolean[imagem.getHeight()][imagem.getWidth()];

        while (!stack.isEmpty()) {
            int y = stack.pop();
            int x = stack.pop();

            if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
                continue;
            }

            if (!visited[y][x] && imagem.getRGB(x, y) == pointZero) {
                imagem.setRGB(x, y, esmeralda);
                visited[y][x] = true;
                panel.repaint();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (y > 0) {
                    stack.push(x);
                    stack.push(y - 1);
                }
                if (y < imagem.getHeight() - 1) {
                    stack.push(x);
                    stack.push(y + 1);
                }
                if (x > 0) {
                    stack.push(x - 1);
                    stack.push(y);
                }
                if (x < imagem.getWidth() - 1) {
                    stack.push(x + 1);
                    stack.push(y);
                }

            }
        }
    }

    public void queueFill(JPanel panel, int startX, int startY) {
        if (startX < 0 || startX >= imagem.getWidth() || startY < 0 || startY >= imagem.getHeight()) {
            throw new IllegalArgumentException("Ponto inicial fora dos limites da imagem!");
        }

        int pointZero = imagem.getRGB(startX, startY);

        if (pointZero == esmeralda) {
            return;
        }

        queue.enqueue(startX);
        queue.enqueue(startY);

        boolean[][] visited = new boolean[imagem.getHeight()][imagem.getWidth()];

        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            int y = queue.dequeue();

            if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
                continue;
            }

            if (!visited[y][x] && imagem.getRGB(x, y) == pointZero) {
                imagem.setRGB(x, y, esmeralda);
                visited[y][x] = true;
                panel.repaint();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (x > 0) {
                    queue.enqueue(x - 1);
                    queue.enqueue(y);
                }
                if (x < imagem.getWidth() - 1) {
                    queue.enqueue(x + 1);
                    queue.enqueue(y);
                }
                if (y > 0) {
                    queue.enqueue(x);
                    queue.enqueue(y - 1);
                }
                if (y < imagem.getHeight() - 1) {
                    queue.enqueue(x);
                    queue.enqueue(y + 1);
                }
            }
        }
    }

}

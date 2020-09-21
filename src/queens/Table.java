package queens;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Table extends JPanel {
    public JButton[][] boxes;

    public Table(int max) {
        boxes = new JButton[max][max];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new JButton();
                boxes[i][j].setEnabled(false);
                boxes[i][j].setPreferredSize(new Dimension(50, 50));
                if ((i + j + 1) % 2 == 0) {
                    boxes[i][j].setBackground(Color.BLACK);
                }
                add(boxes[i][j]);
            }
            setLayout(new GridLayout(max, max));
        }

    }

    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
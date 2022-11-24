package net.mightypork.rpw.gui.widgets;

import javax.swing.*;
import java.awt.*;


public class JPanelWithBackground extends JPanel {

    private Image image;


    public void setBackground(Image image) {
        this.image = image;
        repaint();
    }


    public JPanelWithBackground(Image image) {
        this.image = image;
        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, null);
    }

}

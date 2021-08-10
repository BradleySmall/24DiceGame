package com.small.dicegame;

import javax.swing.*;
import java.awt.*;

public class DiePanel extends JPanel {
    private int currentValue = 0;

    DiePanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRoundRect(0, 0, 60, 60, 30, 30);
        g.setColor(Color.black);
        g.drawRoundRect(0, 0, 60, 60, 30, 30);

        g.setColor(Color.black);
        switch (currentValue) {
            case 1:
                g.fillOval(25, 25, 10, 10);
                break;
            case 2:
                g.fillOval(12, 10, 10, 10);
                g.fillOval(37, 40, 10, 10);
                break;
            case 3:
                g.fillOval(25, 25, 10, 10);
                g.fillOval(12, 10, 10, 10);
                g.fillOval(37, 40, 10, 10);
                break;
            case 4:
                g.fillOval(12, 10, 10, 10);
                g.fillOval(37, 40, 10, 10);
                g.fillOval(37, 10, 10, 10);
                g.fillOval(12, 40, 10, 10);
                break;
            case 5:
                g.fillOval(25, 25, 10, 10);
                g.fillOval(12, 10, 10, 10);
                g.fillOval(37, 40, 10, 10);
                g.fillOval(37, 10, 10, 10);
                g.fillOval(12, 40, 10, 10);
                break;
            case 6:
                g.fillOval(12, 10, 10, 10);
                g.fillOval(37, 10, 10, 10);
                g.fillOval(12, 25, 10, 10);
                g.fillOval(37, 25, 10, 10);
                g.fillOval(12, 40, 10, 10);
                g.fillOval(37, 40, 10, 10);
                break;
            default:
                break;
        }
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        repaint();
    }
}

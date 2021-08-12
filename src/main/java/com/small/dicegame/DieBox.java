/*
 * Copyright (c) 2021. Bradley M. Small
 * All rights reserved.
 */

package com.small.dicegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DieBox extends Box {
    private final int index;
    private int currentValue = 6;
    private final JButton holdButton = new JButton("Hold");

    public DieBox(int index) {
        super(BoxLayout.PAGE_AXIS);
        add(Box.createRigidArea(new Dimension(0, 70)));
        add(holdButton);
        holdButton.setEnabled(false);
        this.index = index;
    }


    public void setButtonEnabled(boolean setValue) {
        holdButton.setEnabled(setValue);
    }

    public boolean isButtonEnabled() {
        return holdButton.isEnabled();
    }

    public void addActionListener(ActionListener e) {
        holdButton.addActionListener(e);
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRoundRect(0, 0, 60, 60, 30, 30);
        g.setColor(Color.black);
        g.drawRoundRect(0, 0, 60, 60, 30, 30);

        if (currentValue >= 1 && currentValue <= 6) {
            g.setColor(Color.black);
            if (currentValue % 2 == 1) {
                drawCenterDot(g);
            }
            if (currentValue > 1) {
                drawTlBrCornerDots(g);
                if (currentValue > 3) {
                    drawTrBlCornerDots(g);
                    if (currentValue == 6) {
                        drawMlMrDots(g);
                    }
                }
            }
        }
    }

    private void drawMlMrDots(Graphics g) {
        drawDots(g, 12, 25, 37, 25);
    }

    private void drawDots(Graphics g, int x1, int y1, int x2, int y2) {
        drawDot(g, x1, y1);
        drawDot(g, x2, y2);
    }

    private void drawCenterDot(Graphics g) {
        drawDot(g, 25, 25);
    }

    private void drawDot(Graphics g, int x, int y) {
        g.fillOval(x, y, 10, 10); // center 5 of 9
    }

    private void drawTlBrCornerDots(Graphics g) {
        drawDots(g, 12, 10, 37, 40);
    }

    private void drawTrBlCornerDots(Graphics g) {
        drawDots(g, 37, 10, 12, 40);
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        repaint();
    }

    public int getIndex() {
        return index;
    }
}

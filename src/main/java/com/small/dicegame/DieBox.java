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
    private JButton holdButton = new JButton("Hold");

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

    public int getIndex() {
        return index;
    }
}

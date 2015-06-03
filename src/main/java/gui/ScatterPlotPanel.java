package gui;

import ch.n1b.mirij2.model.DataSeries;
import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlotPanel extends JPanel {
    Serie xList;
    Serie yList;
    String xName;
    String yName;

    boolean drawLines = false;

    int radius = 5;

    public void setter(Serie seriex, Serie seriey, String nameX, String nameY) {
        this.xList = seriex;
        this.yList = seriey;
        this.xName = nameX;
        this.yName = nameY;
        this.repaint();
    }


    public void drawLine(boolean q) {
        this.drawLines = q;
        repaint();
    }

    public void adjustRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (xList != null && yList != null) {
            double maxvx = xList.range().getY();
            double maxvy = yList.range().getY();
            double minvx = xList.range().getX();
            double minvy = yList.range().getX();


            double xd = (getWidth() - 2 * radius) / (maxvx - minvx);
            double yd = (getHeight() - 2 * radius) / (maxvy - minvy);

            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);

            for (int i = 0; i < xList.size(); i++) {

                g.fillOval((int) ((2 * radius) + (xd * (xList.get(i) - minvx) - 2 * radius)), (int) (getHeight() - (yd * (yList.get(i) - minvy)) - 2 * radius), 2 * radius, 2 * radius);
            }g.setColor(Color.BLACK);
            g.drawString(xName, 10, 20);
            g.drawString(yName, getHeight(), getWidth());

            if (drawLines) {
                for (int i = 0; i < xList.size() - 1; i++) {
                    int j = i + 1;
                    int ax = (int) ((2 * radius) + (xd * (xList.get(i) - minvx) - 2 * radius) + radius);
                    int ay = (int) (getHeight() - (yd * (yList.get(i) - minvy)) - 2 * radius + radius);

                    int bx = (int) ((2 * radius) + (xd * (xList.get(j) - minvx) - 2 * radius) + radius);
                    int by = (int) (getHeight() - (yd * (yList.get(j) - minvy)) - 2 * radius + radius);

                    g.drawLine(ax, ay, bx, by);
                }

            }

            updateUI();
        }

    }
}



package gui;

import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.Main;
import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import gui.MenuPanel;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramLeft extends JPanel {

    Serie xList;
    String xname;


    public HistogramLeft(){


        JLabel nameHL = new JLabel(xname);
        add(nameHL);

    }
    public void histogramL(Serie seriex, String nameX) {
        this.xList = seriex;
        this.xname = nameX;
        this.repaint();
    }

    public void paintComponent (Graphics g) {
        if (xList != null) {
            double maxvx = xList.range().getY();
            double minvx = xList.range().getX();

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            int f = 0;

            //g.setColor(Color.LIGHT_GRAY);
            //g.fillRect(0,0, this.getWidth(), this.getHeight());

            for (int i = 0; i < xList.size(); i++) {

                if (xList.get(i) <= (maxvx / 6)) {
                    a = a + 1;
                } else if ((maxvx / 6) < xList.get(i) && xList.get(i) <= (maxvx / 3)) {
                    b = b + 1;
                } else if ((maxvx / 3) < xList.get(i) && xList.get(i) <= (maxvx / 2)) {
                    c = c + 1;
                } else if ((maxvx / 2) < xList.get(i) && xList.get(i) <= (maxvx / 1.5)) {
                    d = d + 1;
                } else if ((maxvx / 1.5) < xList.get(i) && xList.get(i) <= (maxvx / 1.2)) {
                    e = e + 1;
                } else if ((maxvx / 1.2) < xList.get(i) && xList.get(i) <= (maxvx)) {
                    f = f + 1;
                }
            }

            double h = a + b + c + d + e + f;

            int barHeight = (int) (getHeight() / h);
            int barWidth = (int) (getWidth() / 6.0);

            g.setColor(Color.YELLOW);
            g.fillRect(0, getHeight() - (barHeight * a), (int) (barWidth * 1.0), getHeight());
            g.fillRect((int) (barWidth * 1.0), getHeight() - barHeight * b, (int) (barWidth * 1.0), getHeight());
            g.fillRect((int) (barWidth * 2.0), getHeight() - (barHeight * c), (int) (barWidth * 1.0), getHeight());
            g.fillRect((int) (barWidth * 3.0), getHeight() - (barHeight * d), (int) (barWidth * 1.0), getHeight());
            g.fillRect((int) (barWidth * 4.0), getHeight() - (barHeight * e), (int) (barWidth * 1.0), getHeight());
            g.fillRect((int) (barWidth * 5.0), getHeight() - (barHeight * f), (int) (barWidth * 1.0), getHeight());

            g.setColor(Color.ORANGE);
            g.drawRect(0, getHeight() - (barHeight * a), barWidth, getHeight());
            g.drawRect(barWidth, getHeight() - barHeight * b, barWidth, getHeight());
            g.drawRect(barWidth * 2, getHeight() - (barHeight * c), barWidth, getHeight());
            g.drawRect(barWidth * 3, getHeight() - (barHeight * d), barWidth, getHeight());
            g.drawRect(barWidth * 4, getHeight() - (barHeight * e), barWidth, getHeight());
            g.drawRect(barWidth * 5, getHeight() - (barHeight * f), barWidth, getHeight());

            updateUI();

        }
    }
}

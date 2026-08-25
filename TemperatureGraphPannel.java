package digitaltwin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TemperatureGraphPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ArrayList<Double> tempData = new ArrayList<>();

    public void addTemp(double value) {

        tempData.add(value);

        if (tempData.size() > 20)
            tempData.remove(0);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Temperature Graph", 10, 20);

        int width = getWidth();
        int height = getHeight();

        int step = width / 20;

        // Draw axes
        g.drawLine(20, height - 20, width, height - 20);
        g.drawLine(20, 20, 20, height - 20);

        if (tempData.size() < 2)
            return;

        // find min and max temperature dynamically
        double min = tempData.get(0);
        double max = tempData.get(0);

        for (double t : tempData) {

            if (t < min)
                min = t;

            if (t > max)
                max = t;
        }

        double range = max - min;

        if (range == 0)
            range = 1;

        g.setColor(Color.RED);

        for (int i = 1; i < tempData.size(); i++) {

            int x1 = 20 + (i - 1) * step;
            int x2 = 20 + i * step;

            int y1 = height - 20
                    - (int)((tempData.get(i - 1) - min)
                    * (height - 40) / range);

            int y2 = height - 20
                    - (int)((tempData.get(i) - min)
                    * (height - 40) / range);

            g.drawLine(x1, y1, x2, y2);
        }
    }
}

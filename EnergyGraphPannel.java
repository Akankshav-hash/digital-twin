package digitaltwin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EnergyGraphPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ArrayList<Double> energyData = new ArrayList<>();

    public void addEnergy(double value) {

        energyData.add(value);

        if (energyData.size() > 20)
            energyData.remove(0);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawString("Energy Usage Graph", 10, 20);

        int width = getWidth();
        int height = getHeight();

        int step = width / Math.max(energyData.size(), 1);

        // Draw axes
        g.setColor(Color.BLACK);
        g.drawLine(0, height - 20, width, height - 20); // X axis
        g.drawLine(20, 0, 20, height); // Y axis

        // Draw graph
        g.setColor(Color.BLUE);

        for (int i = 1; i < energyData.size(); i++) {

            int x1 = (i - 1) * step;
            int x2 = i * step;

            int y1 = height - (int)(energyData.get(i - 1) * 10);
            int y2 = height - (int)(energyData.get(i) * 10);

            g.drawLine(x1, y1, x2, y2);
        }
    }
}

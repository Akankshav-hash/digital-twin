package digitaltwin;

import javax.swing.*;
import java.awt.*;

public class ClassroomPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int students = 0;

    public void setStudents(int students) {
        this.students = students;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);

        int rows = 6;
        int cols = 10;
        int seatSize = 20;
        int startX = 20;
        int startY = 60;
        int gapX = 30;
        int gapY = 35;

        // Draw Teacher label
        g.setColor(Color.BLACK);
        g.drawString("Teacher", startX, 30);

        int seatNumber = 0;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (seatNumber < students)
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.LIGHT_GRAY);

                int x = startX + (c * gapX);
                int y = startY + (r * gapY);

                g.fillOval(x, y, seatSize, seatSize);
                g.setColor(Color.BLACK);
                g.drawOval(x, y, seatSize, seatSize);

                seatNumber++;
            }
        }
    }
}

package digitaltwin;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    Classroom classroom;
    EnergyManager energy;
    EnvironmentModel env;

    ClassroomPanel classroomPanel;
    EnergyGraphPanel energyGraph;
    TemperatureGraphPanel tempGraph;

    JLabel studentsLabel;
    JLabel energyLabel;
    JLabel tempLabel;
    JLabel comfortLabel;

    JButton lectureButton;
    JButton reportButton;

    boolean lectureOn = true;

    public MainGUI() {

        classroom = new Classroom(60);
        energy = new EnergyManager();
        env = new EnvironmentModel();

        setTitle("Smart Digital Twin Classroom");
        setSize(1000,650);
        setLayout(new BorderLayout());

        // CENTER → Classroom seating visualization
        classroomPanel = new ClassroomPanel();
        add(classroomPanel, BorderLayout.CENTER);

        // RIGHT SIDE → Information panel
        JPanel rightPanel = new JPanel(new GridLayout(6,1,10,10));

        studentsLabel = new JLabel();
        energyLabel = new JLabel();
        tempLabel = new JLabel();
        comfortLabel = new JLabel();

        lectureButton = new JButton("Toggle Lecture");
        reportButton = new JButton("Export Report");

        rightPanel.add(studentsLabel);
        rightPanel.add(energyLabel);
        rightPanel.add(tempLabel);
        rightPanel.add(comfortLabel);
        rightPanel.add(lectureButton);
        rightPanel.add(reportButton);

        add(rightPanel, BorderLayout.EAST);

        // BOTTOM → Energy graph
        energyGraph = new EnergyGraphPanel();
        energyGraph.setPreferredSize(new Dimension(800,150));
        add(energyGraph, BorderLayout.SOUTH);

        // TOP → Temperature graph
        tempGraph = new TemperatureGraphPanel();
        tempGraph.setPreferredSize(new Dimension(800,120));
        add(tempGraph, BorderLayout.NORTH);

        // Lecture toggle button logic
        lectureButton.addActionListener(e ->
                lectureOn = !lectureOn);

        // Report button logic
        reportButton.addActionListener(e ->

                ReportGenerator.exportReport(
                        classroom.getStudentsPresent(),
                        classroom.getAttendancePercentage(),
                        energy.getEnergyConsumed(),
                        env.getTemperature(),
                        env.getComfortLevel()
                )
        );

        // Timer refresh every 2 seconds
        Timer timer = new Timer(2000, e -> updateSystem());
        timer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateSystem() {

        int students = AttendanceReader.getPresentCount();

        classroom.updateStudents(students);

        classroomPanel.setStudents(students);

        env.update(
                students,
                energy.isFanOn(),
                energy.isProjectorOn(),
                energy.isLightOn(),
                energy.isAcOn()
        );

        energy.update(
                students,
                lectureOn,
                env.getTemperature()
        );

        studentsLabel.setText("Students Present: " + students);

        energyLabel.setText("Energy Used: "
                + energy.getEnergyConsumed());

        tempLabel.setText("Temperature: "
                + env.getTemperature());

        comfortLabel.setText("Comfort Level: "
                + env.getComfortLevel());

        energyGraph.addEnergy(
                energy.getEnergyConsumed());

        tempGraph.addTemp(
                env.getTemperature());

        if (students > 45)

            JOptionPane.showMessageDialog(
                    this,
                    "Overcrowded Classroom!"
            );
    }

    public static void main(String[] args) {

        new MainGUI();
    }
}

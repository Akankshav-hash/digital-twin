# Smart Digital Twin Classroom Monitoring System

A Java Swing desktop application that simulates a real-time "digital twin" of a classroom — modeling student attendance, temperature, energy consumption, and comfort levels through an interactive dashboard.

## Overview

Traditional classroom monitoring relies on manual attendance and disconnected environmental controls, giving no real-time or unified view of classroom conditions. This project applies **Digital Twin** concepts to simulate a classroom environment in software, without requiring physical IoT sensors, and visualizes attendance, environment, and energy behavior on a single dashboard.

## Features

- **Attendance Visualization** — Reads student attendance from a CSV file and renders a live classroom seating layout (occupied vs. empty seats).
- **Environment Simulation** — Dynamically generates realistic temperature values and evaluates classroom comfort status (Comfortable / Not Comfortable) against threshold logic.
- **Energy Monitoring** — Simulates energy consumption from classroom devices (lights, fans, projector, AC) and plots it as a real-time waveform graph.
- **Lecture Automation** — A "Toggle Lecture" control switches the classroom between active and standby modes, dynamically affecting simulated temperature and energy values.
- **Report Export** — Generates a text-based report snapshot of attendance, temperature, comfort status, and energy usage at any point in time.

## Tech Stack

- **Language:** Java
- **GUI:** Java Swing (`JFrame`, `JPanel`, `JLabel`, `JButton`)
- **Concepts:** Object-Oriented Design, File I/O (CSV parsing, report export), Event-driven programming, Custom graphics rendering (`Graphics`, `paintComponent`)

## Project Structure

```
digitaltwin/
├── MainGUI.java             # Main dashboard window; integrates all modules
├── Classroom.java           # Stores classroom capacity and occupancy data
├── ClassroomPanel.java      # Renders the seat occupancy grid
├── AttendanceReader.java    # Reads and parses attendance from CSV
├── AttendancePredictor.java # Evaluates comfort status from temperature
├── EnvironmentModel.java    # Simulates temperature variation
├── EnergyManager.java       # Simulates energy consumption
├── EnergyGraphPanel.java    # Plots real-time energy usage waveform
└── attendance.csv           # Sample attendance input file
```

## How It Works

1. `AttendanceReader` loads `attendance.csv` and counts students marked **Present**.
2. `Classroom` stores this occupancy data; `ClassroomPanel` renders it as a seat grid.
3. `EnvironmentModel` generates temperature readings, evaluated by `AttendancePredictor` to determine comfort status.
4. `EnergyManager` simulates energy usage, influenced by the lecture mode toggle, and plots it via `EnergyGraphPanel`.
5. `MainGUI` ties everything together and exposes **Toggle Lecture** and **Export Report** controls.

## Sample CSV Format (`attendance.csv`)

| Student Name | Attendance Status |
|---|---|
| Rahul | Present |
| Anjali | Absent |

## Getting Started

```bash
# Compile
javac digitaltwin/*.java

# Run
java digitaltwin.MainGUI
```

Make sure `attendance.csv` is present in the working directory before running.

## Future Scope

- Replace simulated values with live sensor data (temperature, occupancy) via Arduino/embedded hardware.
- Add IoT connectivity for remote/cloud-based monitoring.
- Use machine learning to predict environmental behavior and auto-optimize energy usage.
- Automate attendance using computer vision (face recognition) instead of CSV input.
- Extend to a multi-classroom, campus-wide monitoring dashboard.

## Author

**Akanksha V**

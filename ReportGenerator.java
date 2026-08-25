package digitaltwin;

import java.io.FileWriter;

public class ReportGenerator {
	public static void exportReport(
            int students,
            double attendance,
            double energy,
            double temperature,
            String comfort) {

        try {

            FileWriter writer =
                    new FileWriter("ClassroomReport.txt");

            writer.write("SMART CLASSROOM REPORT\n");

            writer.write("Students Present: "
                    + students + "\n");

            writer.write("Attendance %: "
                    + attendance + "\n");

            writer.write("Energy Used: "
                    + energy + "\n");

            writer.write("Temperature: "
                    + temperature + "\n");

            writer.write("Comfort Level: "
                    + comfort + "\n");

            writer.close();
        }

        catch (Exception e) {

            System.out.println("Report error");
        }
    }

}

package digitaltwin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class AttendanceReader {

    public static int getPresentCount() {

        int count = 0;

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("attendance.csv"));

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 3 &&
                        data[2].equalsIgnoreCase("Present"))
                    count++;
            }

            br.close();
        }

        catch (Exception e) {

            Random r = new Random();

            count = 10 + r.nextInt(40);
        }

        return count;
    }
}

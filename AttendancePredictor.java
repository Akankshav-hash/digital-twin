package digitaltwin;

public class AttendancePredictor {

    private static int last1 = 0;
    private static int last2 = 0;

    public static int predictAttendance(int current) {

        int predicted =
                (int)(0.5 * current +
                      0.3 * last1 +
                      0.2 * last2);

        last2 = last1;
        last1 = current;

        return predicted;
    }
}

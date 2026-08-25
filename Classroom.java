package digitaltwin;

public class Classroom {
	private int capacity;
    private int studentsPresent;

    public Classroom(int capacity) {
        this.capacity = capacity;
    }

    public void updateStudents(int students) {
        studentsPresent = students;
    }

    public int getStudentsPresent() {
        return studentsPresent;
    }

    public double getAttendancePercentage() {
        return (studentsPresent * 100.0) / capacity;
    }

}

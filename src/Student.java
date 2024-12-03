public class Student implements MyComparable<Student>{
    private final String name;
    private final int[] marks;

    public Student(String name, int... marks) {
        checkMarks(marks);
        this.name = name;
        this.marks = marks.length > 0 ? marks : new int[0];
    }

    public void checkMarks(int[] marks) {
        for (int mark : marks) {
            if (mark <2 || mark > 5)
                throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        }
    }

    public int[] getMarks() {
        return marks;
    }

    public double averageMark() {
        if (marks.length == 0) return 0;
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum/marks.length;
    }

    public boolean isExellent() {
        if (marks.length == 0) return false;
        for (int mark : marks) {
            if (mark != 5) return false;
        }
        return true;
    }

    public void changeMark(int n, int newMark) {
        if (newMark < 2 || newMark > 5)
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        this.marks[n-1] = newMark;
    }

    public void changeAllMarks(int[] newMarks) {
        checkMarks(newMarks);
        for (int i = 0; i < newMarks.length; i++) {
            this.marks[i] = newMarks[i];
        }
    }

    @Override
    public int compare(Student student) {
        if (this.averageMark() > student.averageMark()) return 1;
        if (this.averageMark() == student.averageMark()) return 0;
        return -1;
    }

    @Override
    public String toString() {
        String array_out = "";
        for (int mark : marks) {
            array_out = array_out + " " + mark;
        }
        return name + ":" + array_out;
    }
}

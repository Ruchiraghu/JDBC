package College;

public class Student {
    private  int rollno;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks='" + marks + '\'' +
                '}';
    }

    public Student(int rollno, String name, String marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    private String marks;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }


}

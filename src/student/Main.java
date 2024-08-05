package student;

public class Main {

    public static void main(String[] args) {
        CrudOperations op = new CrudOperations();
        op.addStudents(new Student(12,"ravi ",89));

    }
}

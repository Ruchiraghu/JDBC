package student;

public class Main {

    public static void main(String[] args) {
        CrudOperations op = new CrudOperations();
//        op.addStudent(new Student(122,"shreya ",89));

        //op.updateData(new Student(1,"rishee",90));
//        op.deleteData(new Student(1,"rishee",90));
        op.readData(1);
    }

}

package org.example.studentrepo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ValidationException {
        LOGGER.setLevel(Level.FINEST);

        Student student1 = new Student("Ana", "Popescu",
                 1996, "female", "12345678");
        Student student2 = new Student("Ion", "Ionescu",
                 2000, "MALE", "23456789");
        Student student3 = new Student("Vasile", "Georgescu",
                 2003, "MALE", "34567890");

        Repository repository = new Repository();

        repository.addStudent(student1);
        repository.addStudent(student2);
        repository.addStudent(student3);
        repository.listStudents();

        repository.retrieveStudentWithAgeX(20);

        repository.removeStudent("1122");
        repository.removeStudent("12345678");
        repository.listStudents();
    }
}
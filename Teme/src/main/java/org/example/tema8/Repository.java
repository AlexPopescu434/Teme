package org.example.studentrepo;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Repository {
    private Logger logger;
    private Set<Student> listOfStudents;

    public Repository() {
        AgeComparator ageComparator = new AgeComparator();
        listOfStudents = new TreeSet<>(ageComparator);
        logger = Logger.getLogger(Repository.class.getName());


        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("src/main/resources/exceptions.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        try {
            validateCorrectYear(student.getdateOfBirth());
            validateEmptyNames(student.getFirstName(), student.getLastName());
            validateGender(student.getGender());

            listOfStudents.add(student);
        } catch (ValidationException e) {
            logger.info(e.getMessage());
           System.out.println(e.getMessage());

        }
    }

    public void removeStudent(String ID) throws ValidationException {
        try {
            validateExistingID(ID);
            validateEmptyID(ID);
        } catch (ValidationException e) {
            logger.info(e.getMessage());

        }
        for (Student student : listOfStudents) {
            if (student.getID().equals(ID)) {
                listOfStudents.remove(student);
            }
        }
    }

    public void retrieveStudentWithAgeX(int studentAge) {
        System.out.println(" List students by age :");
        try {
            validateIntegerAge(studentAge);
            validatePositivedateOfBirth(studentAge);
        } catch (ValidationException e) {
            logger.info(e.getMessage());
            System.out.println(e.getMessage());
        }

        for (Student student : listOfStudents) {
            if (student.getStudentAge() == studentAge) {
                System.out.println(student);
            }
        }
    }

    public void listStudents() throws ValidationException {
        try {
            validateEmptyList();
        } catch (ValidationException e) {
            logger.info(e.getMessage());
            System.out.println(e.getMessage());
        }
        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

    private void validateCorrectYear(int year) throws ValidationException {
        if (year < 1900) {
            throw new ValidationException("Year of birth is not correct!");
        } else if (year > 2005) {
            throw new ValidationException("You have to be 18+ !");
        }
    }

    private void validateEmptyNames(String firstName, String lastName) throws ValidationException {
        if (firstName.equals("") || lastName.equals("")) {
            throw new ValidationException("Name fields can't be empty!");
        }
    }

    private void validateGender(String gender) throws ValidationException {
        gender = gender.toLowerCase();
        if (!gender.equals("M") && !gender.equals("F") && !gender.equals("male") && !gender.equals("female")) {
            throw new ValidationException("Please inside a valid gender format!");
        }
    }
    private void validateEmptyID(String ID) throws ValidationException {
        for (Student student : listOfStudents) {
            if (ID == null) {
                return;
            }
        }
        throw new ValidationException("ID is empty. inside a valid ID!");
    }

    private void validateExistingID(String ID) throws ValidationException {
        for (Student student : listOfStudents) {
            if (ID.equals(student.getID())) {
                return;
            }
        }
        throw new ValidationException("Can't remove a non-existing student!");
    }

    private boolean isInteger(int num) {
        return num == (int) num;
    }

    private void validateIntegerAge(int studentAge) throws ValidationException {
        if (!isInteger(studentAge)) {
            throw new ValidationException("Invalid student age. Age must be a positive integer.");
        }
    }

    private void validatePositivedateOfBirth(int dateOfBirth) throws ValidationException {
        if (dateOfBirth < 0) {
            throw new ValidationException("Age can't be negative!");
        }
    }

    private void validateEmptyList() throws ValidationException {
        if (listOfStudents.isEmpty()) {
            throw new ValidationException("Depozitul de studenți este gol.");
        }
    }

    public Logger getLogger() {
        return logger;
    }

    public Set<Student> getListOfStudents() {
        return listOfStudents;
    }
}

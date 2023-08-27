package org.example.tema8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {
    private Repository repository;

    @Before
    public void setUp() {
        repository = new Repository();
    }

    @Test
    public void testAddValidStudent() {
           Student validStudent = new Student("Ion", "Ionescu",
                   2000, "male", "23456789");
           repository.addStudent(validStudent);
           assertTrue(repository.getListOfStudents().contains(validStudent));
    }

    @Test
    public void testAddInvalidStudent() {
           Student invalidStudent = new Student("Invalid", "Student",
                   2006, "male", "4321");
           repository.addStudent(invalidStudent);
           assertFalse(repository.getListOfStudents().contains(invalidStudent));
    }


    @Test
    public void testRemoveAnExistingStudent() throws ValidationException {

        Student student1 = new Student("Ana", "Popescu",
                1996, "female", "12345678");
        Student student2 = new Student("Ion", "Ionescu",
                2000, "MALE", "23456789");
        repository.addStudent(student1);
        repository.addStudent(student2);

        repository.removeStudent("12345678");
        assertFalse(repository.getListOfStudents().contains(student1));
    }

    @Test
    public void testRemoveAnNonExistingStudent() throws ValidationException {

        Student student1 = new Student("Ana", "Popescu",
                1996, "female", "12345678");
        Student student2 = new Student("Ion", "Ionescu",
                2000, "MALE", "23456789");
        repository.addStudent(student1);
        repository.addStudent(student2);

         try {
             repository.removeStudent("1122");
          } catch (ValidationException e) {
             assertEquals("Can't remove a non-existing student!", e.getMessage());
         }
    }

    @Test
    public void testRetrieveStudentWithASpecificAge() {
        Student student1 = new Student("Ana", "Popescu",
                1996, "female", "12345678");
        Student student2 = new Student("Ion", "Ionescu",
                2000, "MALE", "23456789");
        repository.addStudent(student1);
        repository.addStudent(student2);

        repository.retrieveStudentWithAgeX(23);

    }

    @Test
    public void testListStudentsWhenTheRepositoryIsEmpty() throws ValidationException {

        try {
            repository.listStudents();
        } catch (ValidationException e) {
            assertEquals("Repository is empty.", e.getMessage());
        }
    }

    @Test
    public void testListStudentsWhenTheRepositoryIsNotEmpty() throws ValidationException {

        Student student1 = new Student("Ana", "Popescu",
                1996, "female", "12345678");
        Student student2 = new Student("Ion", "Ionescu",
                2000, "MALE", "23456789");
        repository.addStudent(student1);
        repository.addStudent(student2);


        repository.listStudents();

    }
}


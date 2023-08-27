package org.example.studentrepo;

public class Student {

    private String firstName;
    private String lastName;
    private int dateOfBirth;

    private String gender;
    private String ID;
    private int StudentAge;
    private  int currentAge = 2023;

    public Student(String firstName, String lastName, int dateOfBirth, String gender, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.ID = ID;
        this.currentAge = currentAge;
        this.StudentAge =  StudentAge;

    }
      public int getStudentAge (){
      StudentAge = currentAge - dateOfBirth;
      return StudentAge;
}

    public int getCurrentage() {
        return currentAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getdateOfBirth() {
        return dateOfBirth;
    }


    public String getGender() {
        return gender;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Student[" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", StudentAge=" + StudentAge +
                ", gender='" + gender + '\'' +
                ", ID='" + ID + '\'' +
                ']';
    }
}
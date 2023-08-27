package org.example.tema5_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Unemployed("Maria", 30);
        Person person2 = new Employee("Bogdan", 20);
        Person person3 = new Student("Ana", 25);
        Person person4 = new Employee("Stefan", 28);


        PersonAgeComparator comparatorAge = new PersonAgeComparator();
        TreeSet<Person> ageTreeSet = new TreeSet<>(comparatorAge);
        ageTreeSet.add(person1);
        ageTreeSet.add(person2);
        ageTreeSet.add(person3);
        ageTreeSet.add(person4);

        PersonNameComparator comparatorName = new PersonNameComparator();
        TreeSet<Person> nameTreeSet = new TreeSet<>(comparatorName);
        nameTreeSet.add(person1);
        nameTreeSet.add(person2);
        nameTreeSet.add(person3);
        nameTreeSet.add(person4);

        System.out.println("Persons sorted by age:");
            for (Person person : ageTreeSet) {
                System.out.println(person.getName() + "  " + person.getAge());
            }

        System.out.println("Persons sorted by name:");
            for (Person person : nameTreeSet) {
            System.out.println(person.getName() + "  " + person.getAge());
            }

        HashMap<Person, List<Hobby>> hobbiesList = new HashMap<>();
        Hobby hobby1 = new Hobby("cycling", 1, Arrays.asList(new Address
                ("Victoria Road","Birmingham",new Country("England")),
                new Address("Cosbuc","Timisoara", new Country("Romania"))));
        Hobby hobby2 = new Hobby("swim", 4, Arrays.asList(new Address
                ("Rue de Mulhouse ", "Dijon", new Country("France")),
                 new Address("C. de Sicilia","Madrid",new Country("Spania"))));
        Hobby hobby3 = new Hobby("tennis", 3, Arrays.asList(new Address
                ("Voetweg","Gent", new Country("Belgium")),
                new Address("Via Venezia","Florenta",new Country("Italy"))));
        Hobby hobby4 = new Hobby("football", 5, Arrays.asList(new Address
                ("Ship street","Oxford",new Country("England")),
                new Address("Jan Van Loonslaan","Rotterdam",new Country("Holland"))));

          hobbiesList.put(person1,Arrays.asList(hobby1, hobby2));
          hobbiesList.put(person2,Arrays.asList(hobby1, hobby4));
          hobbiesList.put(person3,Arrays.asList(hobby3, hobby4));
          hobbiesList.put(person4,Arrays.asList(hobby2));


        System.out.println(person3.getName()+"'s hobbies are: ");
            for (Hobby hobby : hobbiesList.get(person3)) {
                System.out.println(hobby.getHobbyName() + "- It can be practiced in the following countries:");

                for (Address address : hobby.getAddressList()) {
                    System.out.println(address.getCountry().getName());
                }
            }

    }

}
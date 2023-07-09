package org.example.tema5_1;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return ComparisonChain.start()
                .compare(o1.getAge(), o2.getAge())
                .result();


    }

}

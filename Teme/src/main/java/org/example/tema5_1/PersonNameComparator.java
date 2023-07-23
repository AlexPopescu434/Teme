package org.example.tema5_1;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return ComparisonChain.start()
                .compare(o1.getName(), o2.getName())
                .result();
    }
}

package org.example.studentrepo;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return ComparisonChain.start()
                .compare(o1.getStudentAge(), o2.getStudentAge())
                .result();
    }

    }


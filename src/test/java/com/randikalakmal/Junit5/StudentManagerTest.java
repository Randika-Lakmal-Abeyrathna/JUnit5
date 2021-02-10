package com.randikalakmal.Junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentManagerTest {


    @Test
    public void shouldCreateStudent() {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("Randika", "Lakmal", "0123456789");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
        Assertions.assertTrue(studentManager.getAllStudents().stream()
                .anyMatch(student -> student.getFirstName().equals("Randika") &&
                        student.getLastName().equals("Lakmal") &&
                        student.getPhoneNumber().equals("0123456789")));
    }

}
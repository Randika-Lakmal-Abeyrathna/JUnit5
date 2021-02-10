package com.randikalakmal.Junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentManagerTest {


    @Test
    @DisplayName("Should Create Contact")
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

    @Test
    @DisplayName("Should Not Create When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        StudentManager studentManager = new StudentManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent(null,"Lakmal","0711596674");
        });
    }
    @Test
    @DisplayName("Should Not Create When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        StudentManager studentManager = new StudentManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent("Randika",null,"0711596674");
        });
    }
    @Test
    @DisplayName("Should Not Create When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        StudentManager studentManager = new StudentManager();
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent("Randika","Lakmal",null);
        });
    }



}
package com.randikalakmal.Junit5;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentManagerTest {

    StudentManager studentManager;

    @BeforeAll
    public void setupAll(){
        System.out.println("Should print before All Tests");
    }

    @BeforeEach
    public void setup(){
        studentManager= new StudentManager();
    }

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateStudent() {
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
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent(null,"Lakmal","0711596674");
        });
    }
    @Test
    @DisplayName("Should Not Create When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent("Randika",null,"0711596674");
        });
    }
    @Test
    @DisplayName("Should Not Create When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
            studentManager.addStudent("Randika","Lakmal",null);
        });
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public void tearDownAll(){
        System.out.println("Should Executed at the end of the Test");
    }



}
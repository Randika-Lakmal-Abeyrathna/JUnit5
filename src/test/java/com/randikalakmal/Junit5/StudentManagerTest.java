package com.randikalakmal.Junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Should Create Student")
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


    @Test
    @DisplayName("Should Create Student Only on MAC OS")
    @EnabledOnOs(value = OS.MAC,disabledReason = "Enabled only on MAC OS")
    public void shouldCreateStudentOnlyOnMac(){
        studentManager.addStudent("Randika","Lakmal","0711596674");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1,studentManager.getAllStudents().size());
        Assertions.assertTrue(studentManager.getAllStudents().stream()
                .anyMatch(student -> student.getFirstName().equals("Randika")&&
                        student.getLastName().equals("Lakmal") &&
                        student.getPhoneNumber().equals("0711596674")));

    }

    @Test
    @DisplayName("Should Not Create Student on WINDOWS OS")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled on WINDOWS OS")
    public void shouldNotCreateStudentOnlyOnWindows(){
        studentManager.addStudent("Randika","Lakmal","0711596674");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1,studentManager.getAllStudents().size());
        Assertions.assertTrue(studentManager.getAllStudents().stream()
                .anyMatch(student -> student.getFirstName().equals("Randika")&&
                        student.getLastName().equals("Lakmal") &&
                        student.getPhoneNumber().equals("0711596674")));

    }


    @Test
    @DisplayName("Test Student Creation on Developer Machine")
    public void shouldTestStudentCreationOnDEV(){
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        studentManager.addStudent("Randika","Lakmal","0711596674");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1,studentManager.getAllStudents().size());

    }

    @DisplayName("Repeat Student Creation Test 5 Times")
    @RepeatedTest(value = 5,
            name = "Repeating Student Creation Test {currentRepetition} od {totalRepetitions}")
    public void shouldTestStudentCreationOnRepeatedly(){
        studentManager.addStudent("Randika","Lakmal","0711596674");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1,studentManager.getAllStudents().size());

    }

    @DisplayName("Student Creation Using Value Source")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789","0123456789","0123456789"})
    public void shouldTestStudentCreationUsingValueSource(String phoneNumber){
        studentManager.addStudent("Randika","Lakmal",phoneNumber);
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1,studentManager.getAllStudents().size());

    }

}
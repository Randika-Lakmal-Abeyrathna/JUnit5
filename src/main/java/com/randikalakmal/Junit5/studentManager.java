package com.randikalakmal.Junit5;

import java.sql.Struct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentManager {

    Map<String,Student> studentList = new ConcurrentHashMap<>();

    public void addStudent(String fistName,String lastName, String phoneNumber){
        Student student = new Student(fistName,lastName,phoneNumber);
        validateStudent(student);
        checkIfStudentAlreadyExist(student);
        studentList.put(generateKey(student),student);
    }

    public Collection<Student> getAllStudents(){
        return studentList.values();
    }

    private void validateStudent(Student student){
        student.validateFirstName();
        student.validateLastName();
        student.validatePhoneNumber();
    }

    private void checkIfStudentAlreadyExist(Student student){
        if (studentList.containsKey(generateKey(student))){
            throw new RuntimeException("Student Already Exist");
        }
    }

    private String generateKey(Student student){
        return String.format("%s-%s",student.getFirstName(),student.getLastName());
    }


}

package com.randikalakmal.Junit5;

public class Student {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Student(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Validation part

    public void validateFirstName(){
        if (this.firstName.isBlank()){
            throw new RuntimeException("Fist Name cannot be null or empty");
        }
    }
    public void validateLastName(){
        if (this.lastName.isBlank()){
            throw new RuntimeException("Last Name cannot be null or empty");
        }
    }
    public void validatePhoneNumber(){
        if (this.phoneNumber.isBlank()){
            throw new RuntimeException("Phone Number cannot be null or empty");
        }

        if (this.phoneNumber.length() != 10){
            throw new RuntimeException("Phone Number Should be 10 Digits long");
        }

        if (this.phoneNumber.matches("\\d+")){
            throw new RuntimeException("Phone Number Contains only digits");
        }

        if(!this.phoneNumber.startsWith("0")){
            throw new RuntimeException("Phone Number should start with 0");
        }
    }

}

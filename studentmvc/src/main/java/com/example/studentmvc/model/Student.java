package com.example.studentmvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Roll number cannot be empty")
    private String rollNumber;

    @Size(min = 5, max = 50, message = "Address must be between 5 and 50 characters")
    private String address;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

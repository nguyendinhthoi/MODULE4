package com.example.form.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "5->45 character")
    private String firstName;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "5->45 character")
    private String lastName;
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Enter begin 0 and has 10 number")
    private String phoneNumber;
    @Min(value = 18, message = "Age > 18")
    private int age;
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Enter begin 0 and has 10 number")
    private String email;
}

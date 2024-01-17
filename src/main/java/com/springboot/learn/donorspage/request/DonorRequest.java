package com.springboot.learn.donorspage.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
public class DonorRequest {

    @NotEmpty(message = "Enter first name")
    private String firstName;

    private String lastName;

    @Min(18)
    private int age;

    private String gender;

    private String bloodGroup;
}

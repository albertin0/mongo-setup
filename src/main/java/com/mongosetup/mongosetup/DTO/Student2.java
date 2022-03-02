package com.mongosetup.mongosetup.DTO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Document(collection="Student2")
public class Student2 {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List<Subject> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private Date created;
    private Date updatedAt;

    public Student2(String firstName, String lastName, String email, Gender gender, Address address, List<Subject> favouriteSubjects, BigDecimal totalSpentInBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
    }

}

package com.mongosetup.mongosetup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Data
@Document(collection = "Persons")
public class Person {

    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isActive")
    private Boolean isActive;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("eyeColor")
    private String eyeColor;

    @JsonProperty("favoriteFruit")
    private String favoriteFruit;

    @JsonProperty("company")
    private Company company;

    @JsonProperty("tags")
    private String[] tags;

    public Person() {
    }

    public Person(@JsonProperty("name")String name, @JsonProperty("isActive")Boolean isActive,
                  @JsonProperty("gender")String gender, @JsonProperty("eyeColor")String eyeColor,
                  @JsonProperty("favoriteFruit")String favoriteFruit, @JsonProperty("company")Company company,
                  @JsonProperty("tags")String[] tags) {
        this.name = name;
        this.isActive = isActive;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.favoriteFruit = favoriteFruit;
        this.company = company;
        this.tags = tags;
    }
}

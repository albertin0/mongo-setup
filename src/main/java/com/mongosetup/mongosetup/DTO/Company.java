package com.mongosetup.mongosetup.DTO;

import lombok.Data;

@Data
public class Company {

    private String title;
    private String email;
    private String phone;
    private Location location;
}

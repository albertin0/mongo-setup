package com.mongosetup.mongosetup.DTO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Subject")
@Slf4j
public class Subject {
    @Id
    private String id;
    private String name;
    private String desc;
    private Date created;

    public Subject(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

//    public static void main(String args[]) {
//        ArrayList<List<Subject>> asd = new ArrayList<>(Arrays.asList(Arrays.asList(new Subject("sdf","dfsfd"))));
//        log.info(String.valueOf(asd.get(0).get(0)));
//    }
}

package com.mongosetup.mongosetup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongosetup.mongosetup.DTO.Person;
import com.mongosetup.mongosetup.Repository.PersonRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddToPersonsColl {

    static PersonRepository repo;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            String fileName = "/Users/licious/Downloads/test.json";
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray)parser.parse(content);
//            Persons allPersons = objectMapper.readValue(String.valueOf(content), Persons.class);
//            for(Person p: allPersons.getLop())    {
//                repo.save(p);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

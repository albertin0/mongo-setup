package com.mongosetup.mongosetup.Controllers;
import com.mongosetup.mongosetup.DTO.Subject;
import com.mongosetup.mongosetup.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository repo;

    @RequestMapping("/subject/addDummyData/{nos}")
    public String addDummyData(@PathVariable int nos)    {
        String[] name = {"English", "Hindi", "Tamil", "Science", "Machine Learning", "AI",
        "Chemistry", "Physics", "Astronomy", "Bengali", "Math"};
        String[] desc = {"Ebola sdfasf", "Hussy adfafafds", "Matthew asdfadsf", "Sharma sdafadf", "Kuchi sdfdaff",
        "Aslam asfdasfd", "Denzin asdfadf", "Mulla asdfasf", "Hola asdfasf", "Henrich adfsasdf", "Sundram sadfafds"};

        for(int i=0;i<nos;i++)  {
            String a1 = name[(int)(Math.random()* (name.length))];
            String a2 = desc[(int)(Math.random()* (desc.length))];
            Subject sub = new Subject(a1,a2);
            sub.setCreated(new Date(System.currentTimeMillis()));
            repo.save(sub);
        }
        return String.valueOf(nos) + " Dummy data Added Successfully!";
    }

    @GetMapping("/subject/findAll")
    public List<Subject> findAll()  {
        return repo.findAll();
    }

    @GetMapping("/subject/format")
    public String format()  {
        List<Subject> subs = repo.findAll();
        for(Subject s:subs) {
            Subject s2 = new Subject(s.getName(),s.getDesc());
            s2.setId(String.valueOf(s.getId()));
            s2.setCreated(new Date(System.currentTimeMillis()));
            repo.deleteById(s.getId());
            repo.save(s2);
        }
        return "Formatting done";
    }

//    @PostMapping("/addStudent")
//    public String saveBook(@RequestBody Student student){
//        repo.save(student);
//        return "Added Successfully";
//    }
//
//    @GetMapping("/findAllStudents")
//    public List<Student> getStudents() {
//        return repo.findAll();
//    }
//
//    @GetMapping("/findByFirstName")
//    public Optional<List<Student>> getStudents2(@RequestParam("first_name") String firstName) {
//        return repo.findByStudentFirstname(firstName);
//    }
//
//    @GetMapping("/findByEmail")
//    public Optional<List<Student>> getStudents(@RequestParam("email") String email) {
//        return repo.findAllStudentsByEmail(email);
//    }
//
//    @GetMapping("/getTotalSpent")
//    public AggregationResults<TotalSpent> getTotalSpent(@RequestParam("first_name") String firstName)   {
//        if(!(firstName.isBlank() || firstName.isEmpty()))
//            return repo.getTotalSpent(firstName);
//        return repo.getTotalSpent();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteBook(@PathVariable String id){
//        repo.deleteById(id);
//        return "Deleted Successfully";
//    }

}
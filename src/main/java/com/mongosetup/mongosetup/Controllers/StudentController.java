package com.mongosetup.mongosetup.Controllers;
import com.mongosetup.mongosetup.DTO.*;
import com.mongosetup.mongosetup.Repository.StudentRepository;
import com.mongosetup.mongosetup.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private SubjectRepository sub_repo;

    @RequestMapping("/student/addDummyData/{nos}")
    public String addDummyData(@PathVariable int nos)    {
        long startTime = System.nanoTime();
        String[] fn = {"John", "James", "Jenny", "Alan", "Peter", "Tommy",
                "Philip", "Atif", "Siva", "Naveen", "Abhi"};
        String[] ln = {"Ebola", "Hussy", "Matthew", "Sharma", "Kuchi",
                "Aslam", "Denzin", "Mulla", "Hola", "Henrich", "Sundram"};
        String[] em = {"asd@gmail.com", "dfg@gmail.com", "sdfs@df.com",
                "lkjn@kj.com"};
        Gender[] gn = {Gender.MALE, Gender.FEMALE};
        Address[] add = {new Address("India", "Mumbai", "100001"),
                new Address("UK","London","234112"),
                new Address("USA","New Jersey","2341321")
        };
        ArrayList<List<String>> fS= new ArrayList<>();
        List<Subject> lS = sub_repo.findAll();
        for(int i=0;i<20;i++) {
            int len = (int) (Math.random() * (10));
            List<String> subs= new ArrayList<>();
            for(int j=0;j<len;j++)  {
                subs.add(lS.get((int)(Math.random()* (lS.size()))).getId());
            }
            fS.add(subs);
        }
        BigDecimal[] tSIB = {new BigDecimal(17),new BigDecimal(34),
                new BigDecimal(312),new BigDecimal(21),
                new BigDecimal(89),new BigDecimal(67),
                new BigDecimal(77)};
        for(int i=0;i<nos;i++)  {
            String a1 = fn[(int)(Math.random()* (fn.length))];
            String a2 = ln[(int)(Math.random()* (ln.length))];
            String a3 = em[(int)(Math.random()* (em.length))];
            Gender a4 = gn[(int)(Math.random()* (gn.length))];
            Address a5 = add[(int)(Math.random()* (add.length))];
            List<String> a6 = fS.get((int)(Math.random()*(fS.size())));
            BigDecimal a7 = tSIB[(int)(Math.random()* (tSIB.length))];
            Student stu = new Student(a1, a2, a3, a4, a5, a6, a7);
            stu.setCreated(new Date(System.currentTimeMillis()));
            repo.save(stu);
        }
        long endTime = System.nanoTime();
        String ret = "Time taken to insert " + String.valueOf(nos) +
                " documents = " + String.valueOf(endTime-startTime) + " nanosecs.";
        return ret;
    }

    @GetMapping("/student/findAll")
    public List<Student> findAll() {
        return repo.findAll();
    }

//    @RequestMapping("/addDummyData/{nos}")
//    public String addDummyData(@PathVariable int nos)    {
//        String[] fn = {"John", "James", "Jenny", "Alan", "Peter", "Tommy",
//        "Philip", "Atif", "Siva", "Naveen", "Abhi"};
//        String[] ln = {"Ebola", "Hussy", "Matthew", "Sharma", "Kuchi",
//        "Aslam", "Denzin", "Mulla", "Hola", "Henrich", "Sundram"};
//        String[] em = {"asd@gmail.com", "dfg@gmail.com", "sdfs@df.com",
//        "lkjn@kj.com"};
//        Gender[] gn = {Gender.MALE, Gender.FEMALE};
//        Address[] add = {new Address("India", "Mumbai", "100001"),
//                new Address("UK","London","234112"),
//                new Address("USA","New Jersey","2341321")
//        };
//        ArrayList<List<String>> fS= new ArrayList<>();
//           fS.add(Arrays.asList("english","maths","programming","science"));
//           fS.add(Arrays.asList("english","science"));
//           fS.add(Arrays.asList("programming", "science"));
//           fS.add(Arrays.asList("maths","english"));
//        BigDecimal[] tSIB = {new BigDecimal(17),new BigDecimal(34),
//                new BigDecimal(312),new BigDecimal(21),
//                new BigDecimal(89),new BigDecimal(67),
//                new BigDecimal(77)};
//        for(int i=0;i<nos;i++)  {
//            String a1 = fn[(int)(Math.random()* (fn.length))];
//            String a2 = ln[(int)(Math.random()* (ln.length))];
//            String a3 = em[(int)(Math.random()* (em.length))];
//            Gender a4 = gn[(int)(Math.random()* (gn.length))];
//            Address a5 = add[(int)(Math.random()* (add.length))];
//            List<String> a6 = fS.get((int)(Math.random()*(fS.size())));
//            BigDecimal a7 = tSIB[(int)(Math.random()* (tSIB.length))];
//            Student stu = new Student(a1, a2, a3, a4, a5, a6, a7);
//            stu.setCreated(new Date(System.currentTimeMillis()));
//            repo.save(stu);
//        }
//        return String.valueOf(nos) + " Dummy data Added Successfully!";
//    }

    @PostMapping("/addStudent")
    public String saveBook(@RequestBody Student student){
        repo.save(student);
        return "Added Successfully";
    }

    @GetMapping("/findAllStudents")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @GetMapping("/findByFirstName")
    public Optional<List<Student>> getStudents2(@RequestParam("first_name") String firstName) {
        return repo.findByStudentFirstname(firstName);
    }

    @GetMapping("/findByEmail")
    public Optional<List<Student>> getStudents(@RequestParam("email") String email) {
        return repo.findAllStudentsByEmail(email);
    }

    @GetMapping("/getTotalSpent")
    public AggregationResults<TotalSpent> getTotalSpent(@RequestParam("first_name") String firstName)   {
        if(!(firstName.isBlank() || firstName.isEmpty()))
            return repo.getTotalSpent(firstName);
        return repo.getTotalSpent();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }

}
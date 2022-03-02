package com.mongosetup.mongosetup.Controllers;
import com.mongosetup.mongosetup.DTO.Address;
import com.mongosetup.mongosetup.DTO.Gender;
import com.mongosetup.mongosetup.DTO.Student2;
import com.mongosetup.mongosetup.DTO.Subject;
import com.mongosetup.mongosetup.Repository.Student2Repository;
import com.mongosetup.mongosetup.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class Student2Controller {

    @Autowired
    private SubjectRepository sub_repo;

    @Autowired
    private Student2Repository repo;

    @RequestMapping("/student2/addDummyData/{nos}")
    public String addDummyData(@PathVariable int nos)    {
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
        ArrayList<List<Subject>> fS= new ArrayList<>();
        List<Subject> lS = sub_repo.findAll();
        for(int i=0;i<20;i++) {
            int len = (int) (Math.random() * (10));
            List<Subject> subs= new ArrayList<>();
            for(int j=0;j<len;j++)  {
                subs.add(lS.get((int)(Math.random()* (lS.size()))));
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
            List<Subject> a6 = fS.get((int)(Math.random()*(fS.size())));
            BigDecimal a7 = tSIB[(int)(Math.random()* (tSIB.length))];
            Student2 stu = new Student2(a1, a2, a3, a4, a5, a6, a7);
            stu.setCreated(new Date(System.currentTimeMillis()));
            repo.save(stu);
        }
        return String.valueOf(nos) + " Dummy data Added Successfully!";
    }

    @GetMapping("/student2/findAll")
    public List<Student2> findAll() {
        return repo.findAll();
    }
//
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
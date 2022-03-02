package com.mongosetup.mongosetup.Repository;

import com.mongosetup.mongosetup.DTO.Student2;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface Student2Repository extends MongoRepository<Student2,String> {

    List<Student2> findAll();

    Optional<List<Student2>> findAllStudentsByEmail(String email);

//    @Query(value="{ 'firstName' : ?0 }")//, fields="{ 'firstName' : 1, 'lastName' : 1}")
//    Optional<List<Student2>> findByStudentFirstname(String firstname);
//
//    @Query(value="{ 'firstName' : ?0 }")//, fields="{ 'firstName' : 1, 'lastName' : 1}")
//    Optional<List<Student>> findByStudentLastname(String lastname);
//
//    @Aggregation(pipeline = {"{$project: {\n" +
//            "        totalSpentInBooks: 1,\n" +
//            "     }}"
////            ,"{$match: {$and : [{year:?0} , {month:?1}] \n" +
////            "     }}"
//            ,"{$match:{}}"
//            ,"{$group: { \n" +
//            "          '_id': {\n" +
////            "            month: {$month: $poDate},\n" +
////            "            year: {$year: $poDate} \n" +
//            "          },\n" +
//            "          totalPrice: {$sum: {$toDecimal:$totalSpentInBooks}},\n" +
//            "          }\n" +
//            "      }"
//            ,"{$project: {\n" +
////            "        _id: 0,\n" +
//            "        totalPrice: {$toString: $totalPrice}\n" +
//            "     }}"
//    })
//    AggregationResults<TotalSpent> getTotalSpent();
//
//    @Aggregation(pipeline = {"{$project: {\n" +
//            "        firstName:1,\n" +
//            "        totalSpentInBooks: 1,\n" +
//            "     }}"
////            ,"{$match: {$and : [{year:?0} , {month:?1}] \n" +
////            "     }}"
//            ,"{$match:{firstName:?0}}"
//            ,"{$group: { \n" +
//            "          '_id': {\n" +
////            "            month: {$month: $poDate},\n" +
////            "            year: {$year: $poDate} \n" +
//            "          },\n" +
//            "          totalPrice: {$sum: {$toDecimal:$totalSpentInBooks}},\n" +
//            "          }\n" +
//            "      }"
//            ,"{$project: {\n" +
////            "        _id: 0,\n" +
//            "        firstName:?0,\n" +
//            "        totalPrice: {$toString: $totalPrice}\n" +
//            "     }}"
//    })
//    AggregationResults<TotalSpent> getTotalSpent(String firstName);
}

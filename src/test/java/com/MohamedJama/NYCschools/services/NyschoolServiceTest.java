package com.MohamedJama.NYCschools.services;

import com.MohamedJama.NYCschools.entity.Nyschool;
import com.MohamedJama.NYCschools.repository.NyschoolsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class NyschoolServiceTest {

    @Autowired
    private NyschoolsRepository nyschoolsRepository;
    @Autowired
    private NyschoolService service;





    @Test
    public void listAllSchools(){
       // can be paged the result and get few records
       List<Nyschool> result = service.listAllSchools();
       result.forEach(p-> System.out.println(p.getSchool_name()));


    }

    @Test
    public void findSchoolBySchoolId(){
        Nyschool schoolById = service.findSchoolById(1L);
        String name = schoolById.getSchool_name();
        assertEquals("HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES", name);
    }
}
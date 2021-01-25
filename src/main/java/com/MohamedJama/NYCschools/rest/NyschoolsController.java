package com.MohamedJama.NYCschools.rest;

import com.MohamedJama.NYCschools.entity.Nyschool;
import com.MohamedJama.NYCschools.repository.NyschoolsRepository;
import com.MohamedJama.NYCschools.services.NyschoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v2.0")
public class NyschoolsController {
    private NyschoolService nyschoolService;
    private NyschoolsRepository nyschoolsRepository;

    public NyschoolsController(NyschoolService nyschoolService, NyschoolsRepository nyschoolsRepository) {
        this.nyschoolService = nyschoolService;
        this.nyschoolsRepository = nyschoolsRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Nyschool>> findAllSchools(){
        return new ResponseEntity<List<Nyschool>>((List<Nyschool>) nyschoolService.listAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nyschool> findSchool(@PathVariable("id") Long id){
        return new ResponseEntity<>(nyschoolService.findSchoolById(id),HttpStatus.OK);
    }
}

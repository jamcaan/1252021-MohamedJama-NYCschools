package com.MohamedJama.NYCschools.services;

import com.MohamedJama.NYCschools.entity.Nyschool;
import com.MohamedJama.NYCschools.repository.NyschoolsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* The code I am writing is self explanatory
* I could also create NychoolsService interface and create impl class, but for simplicity, I just
* Used one Service class.
 */
@Service
public class NyschoolService {

    private NyschoolsRepository nyschoolsRepository;

    public NyschoolService(NyschoolsRepository nyschoolsRepository) {
        this.nyschoolsRepository = nyschoolsRepository;
    }

    public List<Nyschool> listAllSchools(){
        return (List<Nyschool>) nyschoolsRepository.findAll();
    }
    public Nyschool findSchoolById(Long id){
        return nyschoolsRepository.findById(id).stream()
                .filter(s-> id.equals(s.getId()))
                .findFirst().orElseThrow(()-> new IllegalStateException("School" + id + "does not exist"));
    }
}

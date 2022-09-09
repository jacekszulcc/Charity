package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findInstitution(){
        List<Institution> institutionList = (List<Institution>) institutionRepository.findAll();
        if (institutionList.size()<=3){
            for (int i=0;i<=6-institutionList.size();i++){
                institutionList.add(new Institution());
            }
        }
        return institutionList;
    }
}

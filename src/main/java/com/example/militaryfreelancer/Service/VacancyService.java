package com.example.militaryfreelancer.Service;

import com.example.militaryfreelancer.Models.vacany.Vacancy;
import com.example.militaryfreelancer.Repository.VacancyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VacancyService {
    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Transactional
    public void save(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    public Vacancy findById(long id){
        return vacancyRepository.findById(id).orElse(null);
    }

    public void update(long id,Vacancy updateVvacancy){
        Vacancy newVacancy = vacancyRepository.findById(id).orElse(null);
        if (newVacancy != null) {
            newVacancy.setVacancyName(updateVvacancy.getVacancyName());
            newVacancy.setUnitName(updateVvacancy.getUnitName());
            newVacancy.setDescription(updateVvacancy.getDescription());
            newVacancy.setRank(updateVvacancy.getRank());
        }
        vacancyRepository.save(newVacancy);
    }

    public void delete(long id){
        vacancyRepository.delete(findById(id));
    }
}

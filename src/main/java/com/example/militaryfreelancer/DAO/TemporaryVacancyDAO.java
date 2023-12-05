package com.example.militaryfreelancer.DAO;

import com.example.militaryfreelancer.Models.vacany.Vacancy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class    TemporaryVacancyDAO {

    private static int VACANCY_COUNT;
    private final List<Vacancy> vacancyList;

    {
        vacancyList = new ArrayList<>();
    }

    public List<Vacancy> getVacancyList(){
        return vacancyList;
    }

    public Vacancy get(int id){
        return vacancyList
                .stream()
                .filter(vacancy -> vacancy.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void registerCustomer(Vacancy vacancy){
        vacancy.setId(++VACANCY_COUNT);
        vacancyList.add(vacancy);
    }

    public void save(Vacancy vacancy){
        vacancy.setId(++VACANCY_COUNT);
        vacancyList.add(vacancy);
    }

    public Vacancy show(int id){
        return vacancyList.get(id);
    }

    public void update(int id, Vacancy vacancy) {
        Vacancy vacancyWhoIsUpdated = show(id);
        vacancyWhoIsUpdated.setVacancyName(vacancy.getVacancyName());
        vacancyWhoIsUpdated.setUnitName(vacancy.getUnitName());
        vacancyWhoIsUpdated.setPersonName(vacancy.getPersonName());
        vacancyWhoIsUpdated.setRank(vacancy.getRank());
        vacancyWhoIsUpdated.setPhone(vacancy.getPhone());
        vacancyWhoIsUpdated.setEmail(vacancy.getEmail());
    }
}

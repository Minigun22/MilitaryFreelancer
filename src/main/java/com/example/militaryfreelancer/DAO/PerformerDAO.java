package com.example.militaryfreelancer.DAO;

import com.example.militaryfreelancer.Models.Performer.Performer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PerformerDAO {
    private static int CUSTOMERS_COUNT;
    private final List<Performer> performerList;

    {
        performerList = new ArrayList<>();
        performerList.add(new Performer("Vitali", "Datsenko", "@gmail.com", "1234567890"));
    }

    public List<Performer> getPerformerList(){
        return performerList;
    }

    public Performer get(int id){
        return performerList
                .stream()
                .filter(performer -> performer.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void registerCustomer(Performer performer){
        performer.setId(++CUSTOMERS_COUNT);
        performerList.add(performer);
    }

    public void save(Performer performer){
        performerList.add(performer);
    }

}

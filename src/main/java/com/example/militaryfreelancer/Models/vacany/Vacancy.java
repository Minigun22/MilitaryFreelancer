package com.example.militaryfreelancer.Models.vacany;

import com.example.militaryfreelancer.Models.Customer.Rank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Vacancy {
    private int id;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String vacancyName;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String unitName;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String personName;
    private Rank rank;


    public Vacancy(String vacancyName, String unitName, String personName, Rank rank, String email, String phone) {
        this.vacancyName = vacancyName;
        this.unitName = unitName;
        this.personName = personName;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", vacancyName='" + vacancyName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", personName='" + personName + '\'' +
                ", rank=" + rank +
                '}';
    }
}

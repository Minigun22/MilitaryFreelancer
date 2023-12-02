package com.example.militaryfreelancer.Models.vacany;

import com.example.militaryfreelancer.Models.Customer.Rank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vacancy {
    private int id;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String vacancyName;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String unitName;
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String personName;
    private Rank rank;
    @Email(message = "Неправильний формат електронної пошти")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})", message = "Неправильно вказаний номер телефону")
    private String phone;


    public Vacancy(){}

    public Vacancy(String vacancyName, String unitName, String personName, Rank rank, String email, String phone) {
        this.vacancyName = vacancyName;
        this.unitName = unitName;
        this.personName = personName;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", vacancyName='" + vacancyName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", personName='" + personName + '\'' +
                ", rank=" + rank +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package com.example.militaryfreelancer.Models.vacany;

import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Models.Customer.Rank;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="name")
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String vacancyName;
    @Column(name ="unit_name")
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private String unitName;
    @Column(name = "description")
    private String description;
    @Column(name = "performer_rank")
    @Enumerated(EnumType.STRING)
    @Size(min = 2, max = 15, message = "Довжина має бути від 2 до 15 символів")
    private Rank rank;
    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;

    public Vacancy(String vacancyName, String unitName, String personName, Rank rank, String email, String phone) {
        this.vacancyName = vacancyName;
        this.unitName = unitName;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", vacancyName='" + vacancyName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", rank=" + rank +
                '}';
    }
}

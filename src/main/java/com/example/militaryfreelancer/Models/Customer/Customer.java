package com.example.militaryfreelancer.Models.Customer;

import com.example.militaryfreelancer.Models.vacany.Vacancy;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    @NotEmpty(message="Це поле не може бути порожнім")
    @Size(min = 2, max = 15, message="Довжина має бути від 2 до 15 символів")
    private String name;
    @Column(name="surname")
    @NotEmpty(message="Це поле не може бути порожнім")
    @Size(min = 3, max = 25, message="Довжина має бути від 3 до 25 символів")
    private String surname;
    @Column(name="email")
    @Email(message = "Неправильний формат електронної пошти")
    private String email;
    @Column(name="phone")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Неправильно вказаний номер телефону")
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Vacancy> vacancies;

    public Customer() {

    }

    public Customer(String name, String surname, String email, String phone){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone;
    }
}

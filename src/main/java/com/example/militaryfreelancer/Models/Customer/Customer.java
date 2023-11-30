package com.example.militaryfreelancer.Models.Customer;

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
public class Customer {
    private int id;
    @NotEmpty(message="Це поле не може бути порожнім")
    @Size(min = 2, max = 15, message="Довжина має бути від 2 до 15 символів")
    private String name;
    @NotEmpty(message="Це поле не може бути порожнім")
    @Size(min = 3, max = 25, message="Довжина має бути від 3 до 25 символів")
    private String surname;
    @Email(message = "Неправильний формат електронної пошти")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})", message = "Неправильно вказаний номер телефону")
    private String phone;

    public Customer(){

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

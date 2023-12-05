package com.example.militaryfreelancer.Models.Performer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Performer {
    private int id;

    @NotEmpty(message = "Це поле не може бути порожнім")
    @Size(min = 2, max = 15, message="Довжина має бути від 2 до 15 символів")
    private String name;
    @NotEmpty(message = "Це поле не може бути порожнім")
    @Size(min = 2, max = 15, message="Довжина має бути від 2 до 15 символів")
    private String surname;
    @Email(message = "Неправильний формат електронної пошти")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})", message = "Неправильно вказаний номер телефону")
    private String phone;

    public Performer(){

    }

    public Performer(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

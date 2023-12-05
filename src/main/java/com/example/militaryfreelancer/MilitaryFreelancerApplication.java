package com.example.militaryfreelancer;

import com.example.militaryfreelancer.Models.Customer.Customer;
import com.example.militaryfreelancer.Repository.CustomerRepository;
import com.example.militaryfreelancer.Service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MilitaryFreelancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilitaryFreelancerApplication.class, args);
	}


}
package com.phungnt.schoolwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableJpaRepositories("com.phungnt.schoolwebapplication.repository")
@EntityScan("com.phungnt.schoolwebapplication.model")
public class SchoolWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolWebApplication.class, args);
    }

}

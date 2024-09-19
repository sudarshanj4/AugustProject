package com.example.sudarshan_projectspringboot.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="learner")
public class Learner {
    @Id
    private int id;
}

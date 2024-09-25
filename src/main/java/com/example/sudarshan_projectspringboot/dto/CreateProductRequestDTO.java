package com.example.sudarshan_projectspringboot.dto;

import lombok.Data;

@Data
public class CreateProductRequestDTO {
    String name;
    String category;
    String description;
}

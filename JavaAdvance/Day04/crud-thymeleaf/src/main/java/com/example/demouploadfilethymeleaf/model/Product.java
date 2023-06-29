package com.example.demouploadfilethymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    @Size(min=4,max=30, message = "Nhập tên có độ dài từ 4-30 kí tự")
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String detail;
    private MultipartFile photo;
    @NotBlank(message = "Name is mandatory")
    private String category;
}

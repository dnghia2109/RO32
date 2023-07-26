package com.example.springsecurity.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "categories")
//    private List<Blog> blogs = new ArrayList<>();

//    public Category(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
package com.example.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    private int idCategory;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;
}

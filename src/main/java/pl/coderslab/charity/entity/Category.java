package pl.coderslab.charity.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    public Category(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Category() {
    }
}

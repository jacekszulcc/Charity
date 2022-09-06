package pl.coderslab.charity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String description;


    public Institution(Long id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    public Institution() {
    }
}

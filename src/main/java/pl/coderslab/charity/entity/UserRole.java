package pl.coderslab.charity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}

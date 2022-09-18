package pl.coderslab.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer quantity;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Category> categoryList = new ArrayList<>();
    @ManyToOne
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public Donation(Integer quantity, List<Category> categoryList, Institution institution, String street, String city, String zipCode, String phone, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.quantity = quantity;
        this.categoryList = categoryList;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }
}

package kz.segizbay.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description", columnDefinition = "text")
    private String description;

    @Column(name="price")
    private int price;

    @Column(name="city")
    private String city;

    @Column(name="author")
    private String author;
}

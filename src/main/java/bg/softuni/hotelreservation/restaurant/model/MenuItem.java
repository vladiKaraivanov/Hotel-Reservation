package bg.softuni.hotelreservation.restaurant.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne()
    private Menu menu;

    public MenuItem() {
    }

    public MenuItem(String id, String name, BigDecimal price, String description, Menu menu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.menu = menu;
    }
}

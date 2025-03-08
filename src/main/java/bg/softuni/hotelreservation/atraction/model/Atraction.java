package bg.softuni.hotelreservation.atraction.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Atraction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String weekdayHours;
    @Column(nullable = false)
    private String weekendHours;
    @Column(nullable = false)
    private BigDecimal entryFee;
    @Column(nullable = false)
    private String location;

    public Atraction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeekdayHours() {
        return weekdayHours;
    }

    public void setWeekdayHours(String weekdayHours) {
        this.weekdayHours = weekdayHours;
    }

    public String getWeekendHours() {
        return weekendHours;
    }

    public void setWeekendHours(String weekendHours) {
        this.weekendHours = weekendHours;
    }

    public BigDecimal getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(BigDecimal entryFee) {
        this.entryFee = entryFee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

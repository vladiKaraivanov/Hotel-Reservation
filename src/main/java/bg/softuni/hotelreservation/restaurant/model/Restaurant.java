package bg.softuni.hotelreservation.restaurant.model;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    private Menu menu;
    @Enumerated(EnumType.STRING)
    private PriceLevelEnum prices;
    @ManyToMany
    private Set<Hotel> closestHotel;

    public Restaurant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public PriceLevelEnum getPrices() {
        return prices;
    }

    public void setPrices(PriceLevelEnum prices) {
        this.prices = prices;
    }
    //    id: Long (Primary Key)
//name: String
//menu: String
//prices: String
//rating: Double
}

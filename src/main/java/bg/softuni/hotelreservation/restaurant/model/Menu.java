package bg.softuni.hotelreservation.restaurant.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}

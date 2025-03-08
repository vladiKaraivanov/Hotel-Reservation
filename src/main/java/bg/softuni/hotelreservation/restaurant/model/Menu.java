package bg.softuni.hotelreservation.restaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}

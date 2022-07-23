package ru.gritandrey.restaurantvotingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "restaurant_dish")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDish extends AbstractBaseEntity {

    // :TODO: money https://stackoverflow.com/questions/8148684/what-data-type-to-use-for-money-in-java/43051227#43051227
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_name_id")
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "dish_date")
    private LocalDate date;

    public RestaurantDish(Integer id, BigDecimal price, Dish dish, Restaurant restaurant, LocalDate date) {
        super(id);
        this.price = price;
        this.dish = dish;
        this.restaurant = restaurant;
        this.date = date;
    }

    public String toString() {
        return "RestaurantDish(price=" + this.getPrice() + ", name=" +
                this.getDish().getName() + ", restaurantId=" +
                this.getRestaurant().getId() + ", date=" +
                this.getDate() + ")";
    }
}

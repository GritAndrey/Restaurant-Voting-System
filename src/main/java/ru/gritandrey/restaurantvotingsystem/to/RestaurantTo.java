package ru.gritandrey.restaurantvotingsystem.to;

import lombok.Builder;
import lombok.Value;
import ru.gritandrey.restaurantvotingsystem.model.HasId;

@Value
@Builder
public class RestaurantTo implements HasId {
    Integer id;
    String name;
    String address;

    @Override
    public void setId(Integer id) {}

    @Override
    public boolean isNew() {
        return HasId.super.isNew();
    }

    @Override
    public int id() {
        return HasId.super.id();
    }
}

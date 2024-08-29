package com.food.ordering.system.domain.entity.valueobjects;

import java.util.UUID;

public abstract class OrderId extends BaseId<UUID> {
    public OrderId(UUID value) {
        super(value);
    }
}

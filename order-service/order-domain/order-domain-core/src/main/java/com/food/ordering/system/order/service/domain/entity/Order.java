package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.entity.AggregateRoot;
import com.food.ordering.system.domain.entity.valueobjects.*;

import java.util.List;

public class Order extends AggregateRoot<OrderId> {
    private final CustomerId customerId;
    private final RestaurantId restaurantId;
    private final StreetAddress deliveryAddress;
    private final Money price;
    private final List<OrderItem> items;

}

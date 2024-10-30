package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.entity.valueobjects.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}

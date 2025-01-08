package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.entity.valueobjects.BaseId;

// uniquness of OrderItem objects is ONLY important in the aggregate, so UUID wont be needed
public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}

package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.entity.BaseEntity;
import com.food.ordering.system.domain.entity.valueobjects.Money;
import com.food.ordering.system.domain.entity.valueobjects.OrderId;
import com.food.ordering.system.order.service.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    //    quantity x price = subTotal
    private final Money subTotal;

    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubTotal() {
        return subTotal;
    }
}

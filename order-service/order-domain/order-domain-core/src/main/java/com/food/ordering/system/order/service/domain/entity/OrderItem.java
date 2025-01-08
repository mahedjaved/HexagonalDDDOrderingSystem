package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.entity.BaseEntity;
import com.food.ordering.system.domain.entity.valueobjects.Money;
import com.food.ordering.system.domain.entity.valueobjects.OrderId;
import com.food.ordering.system.order.service.domain.valueobject.OrderItemId;

// entites of course inherit from BaseEntity, OrderItem is NOT a value object. However OrderItemID is and is required for Entites to be recognised by VOs
public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    //    quantity x price = subTotal
    private final Money subTotal;

    private OrderItem(Builder builder) {
//        id = builder.id;
//        again we dont need above, we already have an ID setter in the BaseEntity parent class, also builder.id is preserved template in Builder plugin and id is undefined for our case
        super.setId(builder.orderItemId);
        orderId = builder.orderId;
        product = builder.product;
        quantity = builder.quantity;
        price = builder.price;
        subTotal = builder.subTotal;
    }


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

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() && price.equals(product.getPrice()) && price.multiply(quantity).equals(subTotal);
    }

    public static final class Builder {
        //        commented below since it comes with as part of plugin and is undefined for us
//        private ID id;
        private OrderItemId orderItemId;
        private OrderId orderId;
        private Product product;
        private int quantity;
        private Money price;
        private Money subTotal;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderItemId(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder subTotal(Money val) {
            subTotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}

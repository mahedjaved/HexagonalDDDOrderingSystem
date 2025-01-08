package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.entity.BaseEntity;
import com.food.ordering.system.domain.entity.valueobjects.Money;
import com.food.ordering.system.domain.entity.valueobjects.ProductId;

// we dont override hash or equals code here as this entity inherits from BaseEntity class if one looks, the hashCode and equals are already being overwritten there
public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}

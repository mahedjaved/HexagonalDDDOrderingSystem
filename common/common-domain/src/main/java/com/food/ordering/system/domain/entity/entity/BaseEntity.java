package com.food.ordering.system.domain.entity.entity;
import java.util.Objects;

/*
 * Reason why we have "common" module is because alot the entities that domain objects have are similar, these can be defined independantly here
 * Hence have this as an ABSTRACT class
 * doing this also allows easy differentiation of Entity Vs Aggregate Vs Aggregate Root, since these types will expose which abstract class they are implementing
 * */
public abstract class BaseEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    //    Below are "contracts" used to compare two Java objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

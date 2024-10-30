package com.food.ordering.system.domain.entity.entity;

public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
    /*
     * Purely here to be as Base Abstract class for all Aggregate Roots made in different domains
     * This is done since Aggregate Roots have a lot in common, e.g. they all have UUIDs (I think)
     * So why not have a template to follow from
     * It is a marker class --> TODO: search what does marker class mean
     * */
}

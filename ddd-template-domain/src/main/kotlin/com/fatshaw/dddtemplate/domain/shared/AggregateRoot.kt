package com.fatshaw.dddtemplate.domain.shared

import java.time.Instant

abstract class AggregateRoot<ID, T> : Entity<ID, T> {

    abstract val id: ID
    open var version: Long = 0
    open var deleted: Boolean = false
    open var createdAt: Instant = Instant.now()
    open var updatedAt: Instant = Instant.now()

    @Transient
    var domainEvents: MutableList<DomainEvent<*>> = mutableListOf()
}

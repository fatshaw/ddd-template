package com.fatshaw.dddtemplate.domain.shared

interface DomainRepository<ID, T : AggregateRoot<ID, T>> {
    fun save(t: T): T
    fun findById(id: ID): T?
}

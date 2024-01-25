package com.fatshaw.dddtemplate.ddd.common

interface DomainRepository<ID, T : AggregateRoot<ID, T>> {
    fun save(t: T): T
    fun findById(id: ID): T?
}

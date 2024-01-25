package com.fatshaw.dddtemplate.ddd.common

interface DomainEventHandler<T : DomainEvent<*>> {
    fun execute(event: T)
}

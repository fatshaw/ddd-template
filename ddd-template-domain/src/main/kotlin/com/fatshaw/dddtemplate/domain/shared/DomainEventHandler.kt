package com.fatshaw.dddtemplate.domain.shared

interface DomainEventHandler<T : DomainEvent<*>> {
    fun execute(event: T)
}

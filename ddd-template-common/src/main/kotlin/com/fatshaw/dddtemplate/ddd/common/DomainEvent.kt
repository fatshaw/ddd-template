package com.fatshaw.dddtemplate.ddd.common

import java.time.Instant

interface DomainEvent<out T : AggregateRoot<*, *>> {
    val payload: T
    val createdAt: Instant
    val eventId: String
}

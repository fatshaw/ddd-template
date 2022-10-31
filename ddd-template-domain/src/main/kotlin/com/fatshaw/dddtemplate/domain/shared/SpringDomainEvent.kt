package com.fatshaw.dddtemplate.domain.shared

import org.springframework.context.ApplicationEvent
import java.time.Instant
import java.util.*

open class SpringDomainEvent<T : AggregateRoot<*, *>>(
    override val payload: T,
    override val createdAt: Instant = Instant.now(),
    override val eventId: String = UUID.randomUUID().toString()
) : ApplicationEvent(payload), DomainEvent<T>

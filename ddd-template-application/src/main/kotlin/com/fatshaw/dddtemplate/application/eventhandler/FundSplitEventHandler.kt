package com.fatshaw.dddtemplate.application.eventhandler

import com.fatshaw.dddtemplate.domain.fundsplit.model.event.FundSplitDomainEvent
import com.fatshaw.dddtemplate.ddd.common.DomainEventHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class FundSplitEventHandler : DomainEventHandler<FundSplitDomainEvent> {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @EventListener
    override fun execute(event: FundSplitDomainEvent) {
        logger.info("receive fundsplit domain event=${event}")
    }
}

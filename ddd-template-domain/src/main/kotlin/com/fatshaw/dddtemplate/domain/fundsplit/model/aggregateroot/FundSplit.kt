package com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot

import com.fatshaw.dddtemplate.domain.fundsplit.model.event.FundSplitDomainEvent
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitEvent
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitStatus
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitStatusEnum
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceType
import com.fatshaw.dddtemplate.domain.shared.AggregateRoot
import java.math.BigDecimal
import java.util.*

data class FundSplit(
    override var id: String,
    val platformAccountId: String? = null,
    val accountId: String,
    val sourceId: String,
    val sourceType: SourceType,
    val currency: Currency,
    val amount: BigDecimal,
    val destination: String,
    val type: String? = null
) : AggregateRoot<String, FundSplit>() {

    var status: FundSplitStatus =
        FundSplitStatus(FundSplitStatusEnum.CREATED)

    fun apply(event: FundSplitEvent) {
        status.apply(event)
        domainEvents.add(FundSplitDomainEvent(this))
    }
}

package com.fatshaw.dddtemplate.infrastructure.repository.transform

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitStatus
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceType
import com.fatshaw.dddtemplate.infrastructure.repository.po.FundSplitPO
import java.sql.Timestamp
import java.util.*

fun FundSplit.toPO() = FundSplitPO(
    id = id,
    accountId = accountId,
    sourceId = sourceId,
    sourceType = sourceType.name,
    currency = currency.currencyCode,
    amount = amount,
    destination = destination,
    type = type,
    status = status.name()
).apply {
    updatedAt = Timestamp.from(this@toPO.updatedAt)
    createdAt = Timestamp.from(this@toPO.createdAt)
}

fun FundSplitPO.toDO() = FundSplit(
    id = id,
    accountId = accountId,
    sourceId = sourceId,
    sourceType = SourceType.valueOf(sourceType),
    currency = Currency.getInstance(currency),
    amount = amount,
    destination = destination,
    type = type,
).apply {
    status = FundSplitStatus.valueOf(this@toDO.status)
    createdAt = this@toDO.createdAt.toInstant()
    updatedAt = this@toDO.updatedAt.toInstant()
}

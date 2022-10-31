package com.fatshaw.dddtemplate.interfaces.transform

import com.fatshaw.dddtemplate.application.command.CancelFundSplitCommand
import com.fatshaw.dddtemplate.application.command.CreateFundSplitCommand
import com.fatshaw.dddtemplate.application.query.ListFundSplitQuery
import com.fatshaw.dddtemplate.application.query.RetrieveFundSplitQuery
import com.fatshaw.dddtemplate.client.dto.FundSplitDto
import com.fatshaw.dddtemplate.client.dto.enums.FundSplitStatusDto
import com.fatshaw.dddtemplate.client.dto.request.CancelFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.CreateFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.ListFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.RetrieveFundSplitRequestDto
import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceType


fun CreateFundSplitRequestDto.toCommand() = CreateFundSplitCommand(
    accountId = accountId,
    sourceId = sourceId,
    sourceType = SourceType.valueOf(sourceType),
    currency = currency,
    amount = amount,
    destination = destination,
    type = type,
    platformAccountId = platformAccountId
)

fun CancelFundSplitRequestDto.toCommand() =
    CancelFundSplitCommand(accountId = accountId, fundSplitId = fundSplitId)

fun RetrieveFundSplitRequestDto.toQuery() =
    RetrieveFundSplitQuery(accountId = accountId, fundSplitId = fundSplitId)

fun ListFundSplitRequestDto.toQuery() = ListFundSplitQuery(
    accountId = accountId, sourceId = sourceId, sourceType = sourceType, pageNum = pageNum, pageSize = pageSize
)

fun FundSplit.toDto(): FundSplitDto {
    return FundSplitDto(
        id = id,
        platformAccountId = platformAccountId,
        accountId = accountId,
        sourceId = sourceId,
        sourceType = sourceType.name,
        currency = currency,
        amount = amount,
        destination = destination,
        type = type,
        status = FundSplitStatusDto.valueOf(status.name()).name,
        createdAt = createdAt
    )
}

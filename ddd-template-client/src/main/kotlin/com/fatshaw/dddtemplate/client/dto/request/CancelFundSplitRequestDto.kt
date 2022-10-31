package com.fatshaw.dddtemplate.client.dto.request

data class CancelFundSplitRequestDto(
    val accountId: String,
    val fundSplitId: String
)

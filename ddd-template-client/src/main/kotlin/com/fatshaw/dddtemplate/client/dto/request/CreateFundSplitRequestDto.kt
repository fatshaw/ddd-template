package com.fatshaw.dddtemplate.client.dto.request

import java.math.BigDecimal
import java.util.*

data class CreateFundSplitRequestDto(
    val platformAccountId: String? = null,
    val accountId: String,
    val sourceId: String,
    val sourceType: String,
    val currency: Currency,
    val amount: BigDecimal,
    val destination: String,
    val type: String? = null,
)

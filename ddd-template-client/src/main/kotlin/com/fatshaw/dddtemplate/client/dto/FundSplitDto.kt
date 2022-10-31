package com.fatshaw.dddtemplate.client.dto

import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class FundSplitDto(
    val id: String,
    val platformAccountId: String? = null,
    val accountId: String,
    val sourceId: String,
    val sourceType: String,
    val currency: Currency,
    val amount: BigDecimal,
    val destination: String,
    val type: String? = null,
    val status: String,
    val createdAt: Instant
): FailureDto()

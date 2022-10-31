package com.fatshaw.dddtemplate.infrastructure.message.dto

data class SyncFundSplitsDto(
    val requestId: String,
    val platformAccountId: String? = null,
    val accountId: String,
    val sourceId: String,
    val sourceType: String
)

package com.fatshaw.dddtemplate.client.dto.request

data class ListFundSplitRequestDto(
    val accountId: String,
    val sourceId: String? = null,
    val sourceType: String? = null,
    val pageNum: Int = 0,
    val pageSize: Int = 10
)

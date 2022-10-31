package com.fatshaw.dddtemplate.application.query

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.shared.Query
import com.fatshaw.dddtemplate.domain.shared.QueryResult
import com.fatshaw.dddtemplate.domain.shared.pagination.Page

data class ListFundSplitQuery(
    val accountId: String,
    val sourceId: String? = null,
    val sourceType: String? = null,
    val pageNum: Int = 0,
    val pageSize: Int = 10
) : Query

class ListFundSplitQueryResult(val page: Page<FundSplit>) : QueryResult

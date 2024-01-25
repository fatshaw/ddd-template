package com.fatshaw.dddtemplate.domain.fundsplit.repository

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.ddd.common.DomainRepository
import com.fatshaw.dddtemplate.ddd.common.pagination.Page
import com.fatshaw.dddtemplate.ddd.common.pagination.Pageable

interface FundSplitRepository : DomainRepository<String, FundSplit> {
    fun findByAccountIdAndSource(
        accountId: String,
        sourceId: String? = null,
        sourceType: String? = null,
        pageable: Pageable
    ): Page<FundSplit>
}

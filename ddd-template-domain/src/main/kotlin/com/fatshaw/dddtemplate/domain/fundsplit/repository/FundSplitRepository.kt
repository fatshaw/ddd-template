package com.fatshaw.dddtemplate.domain.fundsplit.repository

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.shared.DomainRepository
import com.fatshaw.dddtemplate.domain.shared.pagination.Page
import com.fatshaw.dddtemplate.domain.shared.pagination.Pageable

interface FundSplitRepository : DomainRepository<String, FundSplit> {
    fun findByAccountIdAndSource(
        accountId: String,
        sourceId: String? = null,
        sourceType: String? = null,
        pageable: Pageable
    ): Page<FundSplit>
}

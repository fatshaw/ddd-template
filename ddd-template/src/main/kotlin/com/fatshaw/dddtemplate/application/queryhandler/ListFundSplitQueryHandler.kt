package com.fatshaw.dddtemplate.application.queryhandler

import com.fatshaw.dddtemplate.application.query.ListFundSplitQuery
import com.fatshaw.dddtemplate.application.query.ListFundSplitQueryResult
import com.fatshaw.dddtemplate.domain.fundsplit.repository.FundSplitRepository
import com.fatshaw.dddtemplate.domain.shared.QueryHandler
import com.fatshaw.dddtemplate.domain.shared.pagination.Pageable
import org.springframework.stereotype.Service

@Service
class ListFundSplitQueryHandler(val fundSplitRepository: FundSplitRepository) :
    QueryHandler<ListFundSplitQuery,
            ListFundSplitQueryResult> {
    override fun query(query: ListFundSplitQuery): ListFundSplitQueryResult {
        return ListFundSplitQueryResult(
            fundSplitRepository.findByAccountIdAndSource(
                query.accountId, query.sourceId, query.sourceType,
                Pageable(
                    pageSize = query.pageSize,
                    pageNum = query.pageNum
                )
            )
        )
    }
}

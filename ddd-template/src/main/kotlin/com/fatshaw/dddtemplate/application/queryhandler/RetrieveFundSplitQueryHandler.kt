package com.fatshaw.dddtemplate.application.queryhandler

import com.fatshaw.dddtemplate.application.failure.ApplicationFailure
import com.fatshaw.dddtemplate.application.query.RetrieveFundSplitQuery
import com.fatshaw.dddtemplate.application.query.RetrieveFundSplitQueryResult
import com.fatshaw.dddtemplate.domain.fundsplit.repository.FundSplitRepository
import com.fatshaw.dddtemplate.domain.shared.QueryHandler
import io.vavr.control.Either.left
import io.vavr.control.Either.right
import org.springframework.stereotype.Service

@Service
class RetrieveFundSplitQueryHandler(val fundSplitRepository: FundSplitRepository) :
    QueryHandler<RetrieveFundSplitQuery,
            RetrieveFundSplitQueryResult> {
    override fun query(query: RetrieveFundSplitQuery): RetrieveFundSplitQueryResult {

        return RetrieveFundSplitQueryResult(
            result = fundSplitRepository.findById(query.fundSplitId)?.let { right(it) }
                ?: left(ApplicationFailure.FundSplitNotFound)
        )
    }
}

package com.fatshaw.dddtemplate.application.query

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.shared.Query
import com.fatshaw.dddtemplate.domain.shared.QueryResult
import com.fatshaw.dddtemplate.domain.shared.failure.Failure
import io.vavr.control.Either

data class RetrieveFundSplitQuery(
    val accountId: String,
    val fundSplitId: String
) : Query

class RetrieveFundSplitQueryResult(val result: Either<Failure, FundSplit>) :
    QueryResult

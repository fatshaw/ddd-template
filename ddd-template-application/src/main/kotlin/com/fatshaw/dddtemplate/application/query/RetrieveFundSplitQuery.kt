package com.fatshaw.dddtemplate.application.query

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.ddd.common.Query
import com.fatshaw.dddtemplate.ddd.common.QueryResult
import com.fatshaw.dddtemplate.ddd.common.failure.Failure
import io.vavr.control.Either

data class RetrieveFundSplitQuery(
    val accountId: String,
    val fundSplitId: String
) : Query

class RetrieveFundSplitQueryResult(val result: Either<Failure, FundSplit>) :
    QueryResult

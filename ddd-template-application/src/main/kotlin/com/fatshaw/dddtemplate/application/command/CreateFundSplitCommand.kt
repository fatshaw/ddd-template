package com.fatshaw.dddtemplate.application.command

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceType
import com.fatshaw.dddtemplate.ddd.common.Command
import com.fatshaw.dddtemplate.ddd.common.CommandResult
import com.fatshaw.dddtemplate.ddd.common.failure.Failure
import io.vavr.control.Either
import java.math.BigDecimal
import java.util.*

data class CreateFundSplitCommand(
    val platformAccountId: String? = null,
    val accountId: String,
    val sourceId: String,
    val sourceType: SourceType,
    val currency: Currency,
    val amount: BigDecimal,
    val destination: String,
    val type: String? = null
) : Command

data class CreateFundSplitCommandResult(val fundSplit: Either<Failure, FundSplit>) :
    CommandResult

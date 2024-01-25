package com.fatshaw.dddtemplate.application.command

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.ddd.common.Command
import com.fatshaw.dddtemplate.ddd.common.CommandResult
import com.fatshaw.dddtemplate.ddd.common.failure.Failure
import io.vavr.control.Either

data class CancelFundSplitCommand(
    val accountId: String,
    val fundSplitId: String
) : Command

data class CancelFundSplitCommandResult(val fundSplit: Either<Failure, FundSplit>) :
    CommandResult

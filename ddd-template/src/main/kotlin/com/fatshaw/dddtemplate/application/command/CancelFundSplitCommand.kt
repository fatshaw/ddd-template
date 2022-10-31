package com.fatshaw.dddtemplate.application.command

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.shared.Command
import com.fatshaw.dddtemplate.domain.shared.CommandResult
import com.fatshaw.dddtemplate.domain.shared.failure.Failure
import io.vavr.control.Either

data class CancelFundSplitCommand(
    val accountId: String,
    val fundSplitId: String
) : Command

data class CancelFundSplitCommandResult(val fundSplit: Either<Failure, FundSplit>) :
    CommandResult

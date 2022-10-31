package com.fatshaw.dddtemplate.application.failure

object ApplicationFailure {
    object FundSplitNotFound :
        com.fatshaw.dddtemplate.domain.shared.failure.Failure("FundSplitNotFound", "FundSplitNotFound")

    object NoPermission : com.fatshaw.dddtemplate.domain.shared.failure.Failure("NoPermission", "NoPermission")
}

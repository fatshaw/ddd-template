package com.fatshaw.dddtemplate.application.failure

import com.fatshaw.dddtemplate.ddd.common.failure.Failure

object ApplicationFailure {
    object FundSplitNotFound :
        Failure("FundSplitNotFound", "FundSplitNotFound")

    object NoPermission : Failure("NoPermission", "NoPermission")
}

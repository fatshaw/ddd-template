package com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject

enum class FundSplitStatusEnum {
    CREATED, CANCELLED, FULFILLED
}

data class FundSplitStatus(var status: FundSplitStatusEnum) {
    fun apply(event: FundSplitEvent) {
        status = when (event) {
            FundSplitEvent.ON_CREATE -> {
                FundSplitStatusEnum.CREATED
            }
            FundSplitEvent.ON_CANCEL -> {
                FundSplitStatusEnum.CANCELLED
            }
        }
    }

    fun name() = status.name

    companion object {
        fun valueOf(name: String) = FundSplitStatus(
            FundSplitStatusEnum.valueOf(name)
        )
    }
}

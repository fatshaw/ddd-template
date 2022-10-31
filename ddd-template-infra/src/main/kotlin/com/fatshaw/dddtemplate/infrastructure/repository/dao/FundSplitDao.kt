package com.fatshaw.dddtemplate.infrastructure.repository.dao

import com.fatshaw.dddtemplate.infrastructure.repository.po.FundSplitPO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface FundSplitDao : CrudRepository<FundSplitPO, String> {

    @Query(
        "select f from FundSplitPO f where (f.accountId = :accountId)" +
                " and (:sourceId is null or f.sourceId = :sourceId)" +
                " and (:sourceType is null or f.sourceType = :sourceType)"
    )
    fun findByAccountIdAndSourceIdAndSourceType(
        accountId: String,
        sourceId: String? = null,
        sourceType: String? = null,
        pageable: Pageable
    ): Page<FundSplitPO>
}

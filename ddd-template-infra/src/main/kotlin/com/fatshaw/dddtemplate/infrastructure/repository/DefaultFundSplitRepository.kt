package com.fatshaw.dddtemplate.infrastructure.repository

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.ddd.common.pagination.Page
import com.fatshaw.dddtemplate.ddd.common.pagination.Pageable
import com.fatshaw.dddtemplate.domain.fundsplit.repository.FundSplitRepository
import com.fatshaw.dddtemplate.infrastructure.message.ClearinghouseFundSplitPublisher
import com.fatshaw.dddtemplate.infrastructure.message.dto.SyncFundSplitsDto
import com.fatshaw.dddtemplate.infrastructure.repository.dao.FundSplitDao
import com.fatshaw.dddtemplate.infrastructure.repository.transform.toDO
import com.fatshaw.dddtemplate.infrastructure.repository.transform.toPO
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class DefaultFundSplitRepository(
    val fundSplitDao: FundSplitDao,
    val publisher: ClearinghouseFundSplitPublisher
) : FundSplitRepository {
    override fun findByAccountIdAndSource(
        accountId: String,
        sourceId: String?,
        sourceType: String?,
        pageable: Pageable
    ): Page<FundSplit> {
        return fundSplitDao.findByAccountIdAndSourceIdAndSourceType(
            accountId = accountId,
            sourceId = sourceId,
            sourceType = sourceType,
            pageable = PageRequest.of(
                pageable.pageNum,
                pageable.pageSize
            )
        ).map { it.toDO() }.let {
            Page(
                hasNext = it.hasNext(),
                items = it.content
            )
        }
    }

    override fun findById(id: String): FundSplit? {
        return fundSplitDao.findById(id).orElse(null)?.toDO()
    }

    @Transactional
    override fun save(t: FundSplit): FundSplit {
        val result = fundSplitDao.save(t.toPO()).toDO()
        publisher.publish(
            SyncFundSplitsDto(
                requestId = "",
                platformAccountId = null,
                accountId = "",
                sourceId = "",
                sourceType = ""
            )
        )
        return result.also {
            // test for transactional for db and kafka.
            // throw RuntimeException("rollback")
        }
    }
}

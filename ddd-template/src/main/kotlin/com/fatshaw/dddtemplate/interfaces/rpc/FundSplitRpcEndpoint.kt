package com.fatshaw.dddtemplate.interfaces.rpc


import com.fatshaw.dddtemplate.application.commandhandler.CancelFundSplitCommandHandler
import com.fatshaw.dddtemplate.application.commandhandler.CreateFundSplitCommandHandler
import com.fatshaw.dddtemplate.application.queryhandler.ListFundSplitQueryHandler
import com.fatshaw.dddtemplate.application.queryhandler.RetrieveFundSplitQueryHandler
import com.fatshaw.dddtemplate.client.dto.FundSplitDto
import com.fatshaw.dddtemplate.client.dto.PageResponseDto
import com.fatshaw.dddtemplate.client.dto.ResponseDto
import com.fatshaw.dddtemplate.client.dto.request.CancelFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.CreateFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.ListFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.RetrieveFundSplitRequestDto
import com.fatshaw.dddtemplate.interfaces.transform.toCommand
import com.fatshaw.dddtemplate.interfaces.transform.toDto
import com.fatshaw.dddtemplate.interfaces.transform.toQuery
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
class FundSplitRpcEndpoint(
    val createFundSplitCommandHandler: CreateFundSplitCommandHandler,
    val cancelFundSplitCommandHandler: CancelFundSplitCommandHandler,
    val listFundSplitQueryHandler: ListFundSplitQueryHandler,
    val retrieveFundSplitQueryHandler: RetrieveFundSplitQueryHandler
) : com.fatshaw.dddtemplate.client.rpc.FundSplitRpc {

    @PostMapping("/create")
    override fun create(@RequestBody createFundSplitRequestDto: CreateFundSplitRequestDto): ResponseDto<FundSplitDto> {
        return createFundSplitCommandHandler.execute(createFundSplitRequestDto.toCommand()).fundSplit.fold({
            ResponseDto<FundSplitDto>(failure = it.toDto())
        }, {
            ResponseDto<FundSplitDto>(payload = it.toDto())
        })
    }

    @PostMapping("/cancel")
    override fun cancel(@RequestBody cancelFundSplitRequestDto: CancelFundSplitRequestDto): ResponseDto<FundSplitDto> {
        return cancelFundSplitCommandHandler.execute(cancelFundSplitRequestDto.toCommand()).fundSplit.fold({
            ResponseDto<FundSplitDto>(failure = it.toDto())
        }, {
            ResponseDto<FundSplitDto>(payload = it.toDto())
        })
    }

    @PostMapping("/retrieve")
    override fun retrieve(@RequestBody retrieveFundSplitRequestDto: RetrieveFundSplitRequestDto): ResponseDto<FundSplitDto> {
        return retrieveFundSplitQueryHandler.query(retrieveFundSplitRequestDto.toQuery()).result.fold({
            ResponseDto<FundSplitDto>(failure = it.toDto())
        }, {
            ResponseDto<FundSplitDto>(payload = it.toDto())
        })
    }

    @PostMapping("/list")
    override fun list(@RequestBody listFundSplitRequestDto: ListFundSplitRequestDto): ResponseDto<PageResponseDto<FundSplitDto>> {
        val page = listFundSplitQueryHandler.query(listFundSplitRequestDto.toQuery()).page
        return PageResponseDto(
            hasMore = page.hasNext,
            items = page.items.map { item -> item.toDto() }).let { ResponseDto(it) }
    }
}

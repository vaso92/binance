package com.vasilv.binance.symbol.data.repository

import com.vasilv.binance.client
import com.vasilv.binance.symbol.data.api.BinanceApi
import com.vasilv.binance.symbol.domain.DataError
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.map
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.domain.repository.SymbolRepository

class SymbolRepositoryImpl : SymbolRepository {
    private val api = BinanceApi(client)

    override suspend fun getSymbolList(): Result<List<Symbol>, DataError> =
        api.getTicker()
            .map { tickerResponse ->
                tickerResponse.map {
                    Symbol(
                        askPrice = it.askPrice,
                        askQty = it.askQty,
                        bidPrice = it.bidPrice,
                        bidQty = it.bidQty,
                        closeTime = it.closeTime,
                        count = it.count,
                        firstId = it.firstId,
                        highPrice = it.highPrice,
                        lastId = it.lastId,
                        lastPrice = it.lastPrice,
                        lastQty = it.lastQty,
                        lowPrice = it.lowPrice,
                        openPrice = it.openPrice,
                        openTime = it.openTime,
                        prevClosePrice = it.prevClosePrice,
                        priceChange = it.priceChange,
                        priceChangePercent = it.priceChangePercent,
                        quoteVolume = it.quoteVolume,
                        symbol = it.symbol,
                        volume = it.volume,
                        weightedAvgPrice = it.weightedAvgPrice
                    )
                }
            }

    override fun refreshSymbolList(): Result<Unit, DataError> {
        TODO("Not yet implemented")
    }
}
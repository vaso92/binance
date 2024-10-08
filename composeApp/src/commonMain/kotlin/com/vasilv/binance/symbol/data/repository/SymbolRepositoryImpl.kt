package com.vasilv.binance.symbol.data.repository

import com.vasilv.binance.symbol.data.database.SymbolDatabase
import com.vasilv.binance.symbol.data.database.SymbolEntity
import com.vasilv.binance.symbol.data.repository.remote.SymbolsRemoteDataSource
import com.vasilv.binance.symbol.domain.DataError
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.map
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.domain.repository.SymbolRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class SymbolRepositoryImpl(
    private val symbolsRemoteDataSource: SymbolsRemoteDataSource,
    private val database: SymbolDatabase
) : SymbolRepository {
    override suspend fun getSymbolList(): Flow<Result<List<Symbol>, DataError>> {
        return database.symbolDao().getSymbols()
            .map<List<SymbolEntity>, Result<List<Symbol>, DataError>> { symbolList ->
                Result.Success(symbolList.map {
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
                )
            }.onStart {
                val result = refreshSymbolList()

                if (result is Result.Error) {
                    emit(Result.Error(result.error))
                }
            }
    }

    override suspend fun refreshSymbolList(): Result<Unit, DataError> {
        val apiResult = symbolsRemoteDataSource.fetchLatestSymbols()
            .map { tickerResponse ->
                tickerResponse.map {
                    SymbolEntity(
                        cacheTime = 1,
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


        return apiResult.map {
            when (apiResult) {
                is Result.Error -> apiResult
                is Result.Success -> database.symbolDao().replaceSymbols(apiResult.data)
            }
        }
    }
}
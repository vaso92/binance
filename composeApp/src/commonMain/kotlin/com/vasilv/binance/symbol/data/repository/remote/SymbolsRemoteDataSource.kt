package com.vasilv.binance.symbol.data.repository.remote

import com.vasilv.binance.client
import com.vasilv.binance.symbol.data.api.BinanceApi
import com.vasilv.binance.symbol.data.dto.TickerResponse
import com.vasilv.binance.symbol.domain.DataError
import com.vasilv.binance.symbol.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class SymbolsRemoteDataSource(
    private val binanceApi: BinanceApi = BinanceApi(httpClient = client),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun fetchLatestSymbols(): Result<TickerResponse, DataError> =
        withContext(ioDispatcher) {
            binanceApi.getTicker()
        }
}
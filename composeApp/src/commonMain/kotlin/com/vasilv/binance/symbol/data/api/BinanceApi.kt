package com.vasilv.binance.symbol.data.api

import com.vasilv.binance.symbol.data.dto.TickerResponse
import com.vasilv.binance.symbol.domain.DataError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.serialization.JsonConvertException
import io.ktor.util.network.UnresolvedAddressException

class BinanceApi(private val httpClient: HttpClient) {
    suspend fun getTicker(): com.vasilv.binance.symbol.domain.Result<TickerResponse, DataError.Network> {
        val response = try {
            httpClient.get(
                urlString = "https://api2.binance.com/api/v3/ticker/24hr"
            )
        } catch (e: UnresolvedAddressException) {
            return com.vasilv.binance.symbol.domain.Result.Error(DataError.Network.NO_INTERNET)
        } catch (e: JsonConvertException) {
            return com.vasilv.binance.symbol.domain.Result.Error(DataError.Network.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                com.vasilv.binance.symbol.domain.Result.Success(response.body<TickerResponse>())
            }

            413 -> com.vasilv.binance.symbol.domain.Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
            in 500..599 -> com.vasilv.binance.symbol.domain.Result.Error(DataError.Network.SERVER_ERROR)
            else -> com.vasilv.binance.symbol.domain.Result.Error(DataError.Network.UNKNOWN)
        }
    }
}
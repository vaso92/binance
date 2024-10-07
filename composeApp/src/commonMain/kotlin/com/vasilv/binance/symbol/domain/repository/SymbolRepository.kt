package com.vasilv.binance.symbol.domain.repository

import com.vasilv.binance.symbol.domain.DataError
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.model.Symbol

interface SymbolRepository {
    suspend fun getSymbolList(): Result<List<Symbol>, DataError>

    fun refreshSymbolList(): Result<Unit, DataError>
}
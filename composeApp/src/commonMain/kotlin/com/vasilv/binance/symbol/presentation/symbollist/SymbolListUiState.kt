package com.vasilv.binance.symbol.presentation.symbollist

import com.vasilv.binance.symbol.domain.model.Symbol

data class SymbolListUiState(
    val isRefreshing: Boolean = false,
    val isLoading: Boolean = true,
    val symbolList: List<Symbol> = emptyList()
)
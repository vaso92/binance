package com.vasilv.binance.symbol.presentation.symboldetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.repository.SymbolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SymbolDetailViewModel(
    private val symbolId: String,
    private val symbolRepository: SymbolRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SymbolDetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            symbolRepository.getSymbol(symbolId).collect { symbol ->
                when (symbol) {
                    is Result.Error -> {} // TODO
                    is Result.Success -> _uiState.update { it.copy(symbol = symbol.data) }
                }
            }
        }
    }
}

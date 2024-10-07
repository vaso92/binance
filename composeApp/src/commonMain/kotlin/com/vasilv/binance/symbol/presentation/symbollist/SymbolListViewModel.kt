package com.vasilv.binance.symbol.presentation.symbollist


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasilv.binance.symbol.data.repository.SymbolRepositoryImpl
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.repository.SymbolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SymbolListViewModel(private val symbolRepository: SymbolRepository = SymbolRepositoryImpl()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(SymbolListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            when (val symbolList = symbolRepository.getSymbolList()) {
                is Result.Success -> {
                    _uiState.update { it.copy(isLoading = false, symbolList = symbolList.data) }
                }

                is Result.Error -> {
                    // TODO: handle error
                }
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isRefreshing = true) }
            symbolRepository.refreshSymbolList()
            _uiState.update { it.copy(isRefreshing = false) }
        }
    }
}
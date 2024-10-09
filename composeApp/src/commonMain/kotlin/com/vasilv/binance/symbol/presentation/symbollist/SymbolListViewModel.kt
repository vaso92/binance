package com.vasilv.binance.symbol.presentation.symbollist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasilv.binance.symbol.domain.Result
import com.vasilv.binance.symbol.domain.repository.SymbolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SymbolListViewModel(private val symbolRepository: SymbolRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow(SymbolListUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            symbolRepository.getSymbolList().collect { symbolList ->
                when (symbolList) {
                    is Result.Success -> {
                        _uiState.update { it.copy(isLoading = false, symbolList = symbolList.data) }
                    }

                    is Result.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = symbolList.error.toString()
                            )
                        }
                    }
                }
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isRefreshing = true) }

            val result = symbolRepository.refreshSymbolList()
            val error = if (result is Result.Error) {
                result.error.toString()
            } else {
                null
            }

            _uiState.update { it.copy(isRefreshing = false, error = error) }
        }
    }

    fun onErrorShown() {
        _uiState.update { it.copy(error = null) }
    }
}
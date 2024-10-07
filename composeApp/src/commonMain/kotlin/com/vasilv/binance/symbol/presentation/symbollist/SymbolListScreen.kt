package com.vasilv.binance.symbol.presentation.symbollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SymbolListScreen(viewModel: SymbolListViewModel = viewModel { SymbolListViewModel() }) {
    val lifecycleOwner = androidx.compose.ui.platform.LocalLifecycleOwner.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle(lifecycleOwner)

    SymbolListContent(isLoading = uiState.isLoading, items = uiState.symbolList)
}
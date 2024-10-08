package com.vasilv.binance.symbol.presentation.symboldetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

class SymbolDetailScreen(private val symbolId: String) : Screen {
    @Composable
    override fun Content() {
        val viewModel: SymbolDetailViewModel =
            koinViewModel<SymbolDetailViewModel> { parametersOf(symbolId) }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        uiState.symbol?.let { SymbolDetailContent(it) }
    }
}
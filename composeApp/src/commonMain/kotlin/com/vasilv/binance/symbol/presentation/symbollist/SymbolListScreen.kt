package com.vasilv.binance.symbol.presentation.symbollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.vasilv.binance.symbol.presentation.components.displayError
import com.vasilv.binance.symbol.presentation.symboldetail.SymbolDetailScreen
import org.koin.compose.viewmodel.koinViewModel

class SymbolListScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: SymbolListViewModel = koinViewModel<SymbolListViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val navigator = LocalNavigator.currentOrThrow

        uiState.error?.let {
            displayError(
                errorMessage = it,
                onMessageShown = viewModel::onErrorShown
            )
        }

        SymbolListContent(
            isLoading = uiState.isLoading,
            isRefreshing = uiState.isRefreshing,
            items = uiState.symbolList,
            onSymbolClick = { symbol ->
                navigator.push(SymbolDetailScreen(symbol.symbol))
            },
            onRefresh = viewModel::refresh
        )
    }
}
